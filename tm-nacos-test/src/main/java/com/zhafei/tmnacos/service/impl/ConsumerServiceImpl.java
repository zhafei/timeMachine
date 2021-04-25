package com.zhafei.tmnacos.service.impl;

import com.zhafei.tmnacos.service.ConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author yyf
 * @version v1.0
 * @description
 * @create 2021/4/25 17:12:38
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String getMess(String mess) {
        return mess;
    }
}
