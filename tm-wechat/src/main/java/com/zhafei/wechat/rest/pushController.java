package com.zhafei.wechat.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class pushController {
    @GetMapping(value="{id}")
    public Object accuratePush(@PathVariable String id){

        return id;
    }
}
