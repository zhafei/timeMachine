package com.zhafei.ums.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/new_account")
    public ResponseEntity<Object> register(){
        return null;
    }
}
