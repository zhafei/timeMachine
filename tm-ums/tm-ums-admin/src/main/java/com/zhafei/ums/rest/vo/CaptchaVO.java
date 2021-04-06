package com.zhafei.ums.rest.vo;

/**
 * @author yyf
 * @version v1.0
 * @description 验证码VO
 * @create 2021/4/6 17:06:00
 */
public class CaptchaVO {
    /**
     * 验证码获取方式
     */
    private String type;
    /**
     * 邮箱或手机号
     */
    private String number;
    /**
     * 验证码类型
     */
    private String captchaType;
    /**
     * 验证码
     */
    private String  captcha;
}
