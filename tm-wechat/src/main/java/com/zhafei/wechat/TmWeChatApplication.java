package com.zhafei.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yyf
 * @EnableFeignClients 表示启用feign
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TmWeChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmWeChatApplication.class);
    }
}
