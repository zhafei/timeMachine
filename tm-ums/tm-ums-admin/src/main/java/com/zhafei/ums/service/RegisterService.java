package com.zhafei.ums.service;

import com.zhafei.ums.rest.vo.CaptchaVO;

/**
 * @author yyf
 * @version v1.0
 * @description 用户注册接口
 * @create 2021/4/7 15:58:28
 */
public interface RegisterService {
    public abstract boolean sendCaptcha(CaptchaVO captchaVO);

    public abstract void verifyCaptcha(CaptchaVO captchaVO);
}
