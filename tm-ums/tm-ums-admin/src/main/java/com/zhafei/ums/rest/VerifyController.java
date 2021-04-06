package com.zhafei.ums.rest;

import com.zhafei.ums.rest.vo.CaptchaVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version v1.0
 * @description 验证码控制类
 * @create 2021/4/6 17:03:49
 */
@RestController
public class VerifyController {
    @PostMapping("/send_captcha")
    public ResponseEntity<Object> send_captcha(CaptchaVO captchaVO){
        return null;
    }
}
