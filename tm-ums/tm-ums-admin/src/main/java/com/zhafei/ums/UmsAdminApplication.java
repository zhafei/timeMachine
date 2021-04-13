package com.zhafei.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yyf
 * @version v1.0
 * @description 用户服务系统入口
 * @create 2021/4/4 0:14:16
 */
@SpringBootApplication(scanBasePackages = {"com.zhafei"})
public class UmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminApplication.class);
    }
}
