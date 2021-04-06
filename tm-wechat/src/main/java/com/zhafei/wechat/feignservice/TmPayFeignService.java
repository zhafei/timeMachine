package com.zhafei.wechat.feignservice;

import com.zhafei.wechat.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient(name="tm-pay-service",value="tm-pay-service")
public interface TmPayFeignService {

    @PostMapping("wechatpay")
    public abstract Result<Object> weChatPay(BigDecimal value);
}
