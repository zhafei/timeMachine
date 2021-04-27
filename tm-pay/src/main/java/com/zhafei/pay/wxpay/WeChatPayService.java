package com.zhafei.pay.wxpay;

import com.zhafei.pay.common.vo.Result;

import java.math.BigDecimal;

/**
 * @author yyf
 * @version v1.0
 * @description 第三方微信支付
 * @create 2021/4/6 11:26:36
 */
public interface WeChatPayService {
    public  abstract Result<Object> weChatPay(BigDecimal value);

}
