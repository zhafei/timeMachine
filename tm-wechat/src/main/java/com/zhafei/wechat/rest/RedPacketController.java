package com.zhafei.wechat.rest;

import com.zhafei.wechat.common.vo.Result;
import com.zhafei.wechat.feignservice.TmPayFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/redpacket")
public class RedPacketController {
    @Autowired
    private TmPayFeignService tmPayFeignService;
    @PostMapping("give/{value}")
    public Result<Object> give(@PathVariable BigDecimal value){
        Result result =  tmPayFeignService.weChatPay(value);
        return result;
    }
}
