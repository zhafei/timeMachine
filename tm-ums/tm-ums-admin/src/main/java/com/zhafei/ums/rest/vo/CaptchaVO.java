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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        this.captchaType = captchaType;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
