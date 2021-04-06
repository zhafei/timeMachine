package com.zhafei.pay.service.impl;

import com.zhafei.pay.common.vo.Result;
import com.zhafei.pay.service.WeChatPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yyf
 * @version v1.0
 * @description
 * @create 2021/4/6 11:30:52
 */
@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    @Override
    public Result<Object> weChatPay(BigDecimal value) {
        return Result.OK("支付成功！",value);
    }
}
