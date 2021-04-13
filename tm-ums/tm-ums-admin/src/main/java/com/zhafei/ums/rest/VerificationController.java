package com.zhafei.ums.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version v1.0
 * @description 验证码
 * @create 2021/4/12 9:59:46
 */
@RestController
@RequestMapping("/verify")
public class VerificationController {

    public ResponseEntity<Object> code(){

        return null;
    }
}
