package com.zhafei.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TmPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmPayApplication.class);
    }
}
