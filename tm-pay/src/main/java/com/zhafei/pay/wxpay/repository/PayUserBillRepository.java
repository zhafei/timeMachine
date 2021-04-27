package com.zhafei.pay.wxpay.repository;

import com.zhafei.pay.wxpay.model.PayUserBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayUserBillRepository extends JpaRepository<PayUserBill, Long>, JpaSpecificationExecutor<PayUserBill> {

}