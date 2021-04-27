package com.zhafei.pay.wxpay.impl;

import com.zhafei.common.util.SnowflakeIdWorker;
import com.zhafei.pay.common.vo.Result;
import com.zhafei.pay.wxpay.WeChatPayService;
import com.zhafei.pay.wxpay.model.PayUserBill;
import com.zhafei.pay.wxpay.repository.PayUserBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yyf
 * @version v1.0
 * @description
 * @create 2021/4/6 11:30:52
 */
@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    @Autowired
    private PayUserBillRepository payUserBillRepository;
    @Override
    public Result<Object> weChatPay(BigDecimal value) {
        PayUserBill payUserBill = new PayUserBill();
        payUserBill.setId(new SnowflakeIdWorker(0,0).nextId());
        payUserBill.setUserId(0L);
        payUserBill.setPayType("");
        payUserBill.setPayWay("");
        payUserBill.setAmount(value);
        payUserBill.setResultCode("");
        payUserBill.setResultNote("");
        payUserBill.setReceiptTime(new Date());
        payUserBill.setPayState("");
        payUserBill.setCheckState("");
        payUserBill.setCreateTime(new Date());
        payUserBill.setUpdateTime(new Date());
        payUserBill.setDel(false);

        payUserBill =  payUserBillRepository.save(payUserBill);

        return Result.OK("支付成功！",payUserBill);
    }
}
