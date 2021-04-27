package com.zhafei.pay.wxpay.rest;

import com.zhafei.pay.common.vo.Result;
import com.zhafei.pay.wxpay.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PayController {
    @Autowired
    private WeChatPayService weChatPayService;
    @PostMapping(value="wechatpay/{value}")
    public Result<Object> weChatPay(@PathVariable  BigDecimal value){
        return weChatPayService.weChatPay(value);
    }
}
