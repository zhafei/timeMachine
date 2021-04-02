package com.zhafei.wechat.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class pushController {
    @GetMapping(value="1")
    public Object accuratePush(String id){
        return "111";
    }
}
