package com.zhafei.ums.rest;

import com.zhafei.ums.rest.vo.CaptchaVO;
import com.zhafei.ums.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version v1.0
 * @description 用户注册控制类
 * @create 2021/4/6 16:31:55
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/new_account")
    public ResponseEntity<Object> register(@Validated @RequestBody CaptchaVO captchaVO){
        System.out.println(captchaVO.getNumber());
        registerService.sendCaptcha(captchaVO);


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/code")
    public ResponseEntity<Object> captcha(CaptchaVO captchaVO){
        registerService.sendCaptcha(captchaVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
