package com.zhafei.pay.wxpay.model;


import com.zhafei.pay.base.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pay_user_bill")
public class PayUserBill extends BaseModel<PayUserBill> {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "pay_type")
    private String payType;

    /**
     * 支付方式：1、微信；2、支付宝；3、网银；4、其他
     */
    @Column(name = "pay_way")
    private String payWay;

    /**
     * 金额（元）
     */
    @Column(name = "amount")
    private BigDecimal amount;

    /**
     * 返回码
     */
    @Column(name = "result_code")
    private String resultCode;

    /**
     * 返回信息
     */
    @Column(name = "result_note")
    private String resultNote;

    /**
     * 支付回执更新时间
     */
    @Column(name = "receipt_time")
    private Date receiptTime;

    /**
     * 支付状态：1、待支付；2、支付中；3、成功；4、失败
     */
    @Column(name = "pay_state")
    private String payState;

    /**
     * 对账状态：1、未对账；2、对账中；3、对账成功；4、对账失败
     */
    @Column(name = "check_state")
    private String checkState;

    /**
     * 版本号(乐观锁)
     */
    @Version
    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    @Column(name = "is_del")
    private Boolean del;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /**
     * 用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户编号
     */
    public Long getUserId() {
        return userId;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    /**
     * 支付方式：1、微信；2、支付宝；3、网银；4、其他
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    /**
     * 支付方式：1、微信；2、支付宝；3、网银；4、其他
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * 金额（元）
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 金额（元）
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 返回码
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 返回码
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 返回信息
     */
    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    /**
     * 返回信息
     */
    public String getResultNote() {
        return resultNote;
    }

    /**
     * 支付回执更新时间
     */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * 支付回执更新时间
     */
    public Date getReceiptTime() {
        return receiptTime;
    }

    /**
     * 支付状态：1、待支付；2、支付中；3、成功；4、失败
     */
    public void setPayState(String payState) {
        this.payState = payState;
    }

    /**
     * 支付状态：1、待支付；2、支付中；3、成功；4、失败
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 对账状态：1、未对账；2、对账中；3、对账成功；4、对账失败
     */
    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }

    /**
     * 对账状态：1、未对账；2、对账中；3、对账成功；4、对账失败
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 版本号(乐观锁)
     */
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    /**
     * 版本号(乐观锁)
     */
    public Long getVersionId() {
        return versionId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Boolean isDel() {
        return del;
    }

    @Override
    public String toString() {
        return "PayUserBill{" +
                "id=" + id + '\'' +
                "userId=" + userId + '\'' +
                "payType=" + payType + '\'' +
                "payWay=" + payWay + '\'' +
                "amount=" + amount + '\'' +
                "resultCode=" + resultCode + '\'' +
                "resultNote=" + resultNote + '\'' +
                "receiptTime=" + receiptTime + '\'' +
                "payState=" + payState + '\'' +
                "checkState=" + checkState + '\'' +
                "versionId=" + versionId + '\'' +
                "createTime=" + createTime + '\'' +
                "updateTime=" + updateTime + '\'' +
                "del=" + del + '\'' +
                '}';
    }
}
