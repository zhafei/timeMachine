package com.zhafei.wechat.rest;

import com.zhafei.wechat.feignservice.TmPayFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redpacket")
public class RedPacketController {
    @Autowired
    private TmPayFeignService tmPayFeignService;
    @PostMapping("give")
    public Object give(){
        String s = (String) tmPayFeignService.weChatPay();
        System.out.println(s);
        return s;
    }
}
