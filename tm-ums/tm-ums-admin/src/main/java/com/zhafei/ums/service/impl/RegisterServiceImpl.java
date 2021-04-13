package com.zhafei.ums.service.impl;

import com.zhafei.common.dto.MailDto;
import com.zhafei.common.util.RabbitMQUtil;
import com.zhafei.common.util.RedisUtil;
import com.zhafei.common.util.SnowflakeIdWorker;
import com.zhafei.ums.exception.UmsException;
import com.zhafei.ums.lang.Assert;
import com.zhafei.ums.rest.vo.CaptchaVO;
import com.zhafei.ums.service.RegisterService;
import com.zhafei.ums.util.RandomUtil;
import com.zhafei.ums.util.StrFormatterUtil;
import com.zhafei.ums.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yyf
 * @version v1.0
 * @description
 * @create 2021/4/7 16:08:50
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private final static String CODE_PREFIX = "register_captcha_";
    @Value("${captcha.expiration:60}")
    private long expiration;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RabbitMQUtil rabbitMQUtil;

    @Override
    public boolean sendCaptcha(CaptchaVO captchaVO) {
        if (ValidateUtil.checkEmail(captchaVO.getNumber())) {
            //此处需要引入redis做验证码缓存，鉴于分布式服务中缓存需要共享，所以redis放到基础公用模块
            String redisKey = "register_code_" + captchaVO.getNumber();
            Object oldCode = redisUtil.get(redisKey);
            Long id = new SnowflakeIdWorker(0L, 0L).nextId();
            MailDto mailDto = new MailDto().setId(id).setRecipientAddress(captchaVO.getNumber()).setMailSubject("注册信息");
            if (oldCode == null) {
                String code = RandomUtil.randomNumbers(6);
                // 存入缓存
                if (!redisUtil.set(redisKey, code, expiration)) {
                    throw new UmsException("redis 服务异常");
                }
                String context = StrFormatterUtil.format("<br><p>验证码:{}</p>", code);

                rabbitMQUtil.sendMsg("captcha", "tm.email", mailDto.setMailContext(context));
//                    MailUtil.sendMail(captchaVO.getNumber(),"注册信息", StrFormatterUtil.format("<br><p >验证码:{}</p>", code))
            } else {
                String context = StrFormatterUtil.format("<br><p>验证码:{}</p>", oldCode);
                System.out.println(mailDto.toString());
                rabbitMQUtil.sendMsg("captcha", "tm.email", mailDto.setMailContext(context));
//                    MailUtil.sendMail(captchaVO.getNumber(),"注册信息", StrFormatterUtil.format("<br><p >验证码:{}</p>", oldCode))
            }

        } else if (ValidateUtil.isMobileNo(captchaVO.getNumber())) {
            //暂不提供短信验证码服务
            throw new UmsException("暂无短信验证码服务");
        }
        return true;
    }

    @Override
    public void verifyCaptcha(CaptchaVO captchaVO) {
        Assert.notNull(captchaVO);
        String redisKey = CODE_PREFIX + captchaVO.getNumber();
        Object code = redisUtil.get(redisKey);
        if (code == null) {
            throw new UmsException("验证码过期");
        } else {
            if (!code.toString().equals(captchaVO.getCaptcha())) {
                throw new UmsException("验证码错误");
            } else {
                redisUtil.del(redisKey);
            }
        }
    }
}
