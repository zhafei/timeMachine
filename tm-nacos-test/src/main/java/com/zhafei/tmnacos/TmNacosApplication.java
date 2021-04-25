package com.zhafei.tmnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yyf
 * @version v1.0
 * @description 服务注册与发现
 * @create 2021/4/24 10:26:23
 */
@SpringBootApplication
//开启服务发现
@EnableDiscoveryClient
public class TmNacosApplication {
    public static void main(String[] args)  {
        SpringApplication.run(TmNacosApplication.class);
    }
}
