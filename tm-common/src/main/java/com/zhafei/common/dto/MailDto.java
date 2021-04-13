package com.zhafei.common.dto;

import java.io.Serializable;

/**
 * @author yyf
 * @version v1.0
 * @description 邮件传输对象
 * @create 2021/4/10 12:11:31
 */
public class MailDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 接收人邮箱
     */
    private String recipientAddress;
    /**
     * 邮件主题
     */
    private String mailSubject;
    /**
     * 邮件内容
     */
    private String mailContext;

    public String getRecipientAddress() {
        return recipientAddress;
    }
    public MailDto setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
        return this;
    }

    public String getMailSubject() {
        return mailSubject;
    }
    public MailDto setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
        return this;
    }

    public String getMailContext() {
        return mailContext;
    }
    public MailDto setMailContext(String mailContext) {
        this.mailContext = mailContext;
        return this;
    }

    public Long getId() {
        return id;
    }
    public MailDto setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "MailDto{" +
                "id=" + id +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", mailContext='" + mailContext + '\'' +
                '}';
    }
}
