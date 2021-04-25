package com.zhafei.wechat.feignservice;

import com.zhafei.wechat.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * 服务来源与nacos注册中心
 */
@FeignClient(name="tm-pay-service",value="tm-pay-service")
public interface TmPayFeignService {
    @PostMapping(value="wechatpay/{value}")
    public abstract Result<Object> weChatPay(@PathVariable BigDecimal value);
}
