package com.zhafei.ums.service.impl;

import com.zhafei.common.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
@SpringBootTest
class RegisterServiceImplTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Test
    void sendCaptcha() {
//        redisTemplate.opsForValue().set("1", 1, 10, TimeUnit.SECONDS);
        redisUtil.set("1", 1, 10);
    }

    @Test
    void verifyCaptcha() {
    }
}