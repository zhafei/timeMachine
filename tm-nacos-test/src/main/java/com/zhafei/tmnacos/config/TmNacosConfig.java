package com.zhafei.tmnacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version v1.0
 * @description 配置类
 * @create 2021/4/24 18:54:40
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class TmNacosConfig {
    @Value("${test.name:asdsa}")
    private String useLocalCache;

    @GetMapping("/get")
    public String get() {
        System.out.println(useLocalCache);
        return useLocalCache;
    }
}
