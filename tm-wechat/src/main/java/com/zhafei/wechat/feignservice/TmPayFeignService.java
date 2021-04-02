package com.zhafei.wechat.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="tm-pay-service",value="tm-pay-service")
public interface TmPayFeignService {

    @PostMapping("wechatpay")
    public abstract String weChatPay();
}
