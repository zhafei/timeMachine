package com.zhafei.pay.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @PostMapping(value="wechatpay")
    public String weChatPay(){
        return "pay";
    }
}
