package com.zhafei.tmmail.mail;

import com.zhafei.common.dto.MailDto;
import com.zhafei.common.util.SystemClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件工具类，基于javax.mail封装
 * @author yyf
 */
@Component
public class MailUtil {
    /**
     * 发件人地址
     */
    @Value("${mail.addr:buer_y@126.com}")
    private  String senderAddress1 ;
    /**
     * 发件人账户名
     */
    @Value("${mail.username:buer_y@126.com}")
    private  String senderAccount1;
    /**
     * 发件人账户密码  邮箱smtp的授权码
     */
    @Value("${mail.password:buer_y@126.com}")
    private  String senderPassword1;
    /**
     * 发件人地址
     */
    private static String senderAddress ;
    /**
     * 发件人账户名
     */
    private static String senderAccount;
    /**
     * 发件人账户密码  邮箱smtp的授权码
     */
    private static String senderPassword;
    @PostConstruct
    public void init() {
        MailUtil.senderAccount=this.senderAccount1;
        MailUtil.senderAddress=this.senderAddress1;
        MailUtil.senderPassword=this.senderPassword1;
    }
    /**
     * @param recipientAddress 接收人的邮箱
     * @param mailSubject      邮件的主题
     * @param mailContext      邮件正文
     * @throws Exception
     */
    public static void sendMail(String recipientAddress, String mailSubject, String mailContext) throws MessagingException {
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.126.com");
        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        //3、创建邮件的实例对象
        Message msg = getMimeMessage(session, recipientAddress, mailSubject, mailContext);
        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(senderAccount, senderPassword);
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg, msg.getAllRecipients());
        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")})
        //5、关闭邮件连接
        transport.close();
    }

    /**
     * 发送邮件
     * @param mailDto
     * @throws MessagingException
     */
    public static void sendMail(MailDto mailDto) throws MessagingException {
        if(mailDto!=null) {
            MailUtil.sendMail(mailDto.getRecipientAddress(),mailDto.getMailSubject(),mailDto.getMailContext());
        }
    }
    /**
     * 获得创建一封邮件的实例对象
     *
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public static MimeMessage getMimeMessage(Session session, String recipientAddress, String mailSubject, String mailContext) throws MessagingException {
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(senderAddress));
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
        //设置邮件主题
        msg.setSubject(mailSubject, "UTF-8");
        //设置邮件正文
        msg.setContent(mailContext, "text/html;charset=UTF-8");
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date(SystemClock.now()));
        return msg;
    }

    public static void main(String[] args) throws Exception {
        MailUtil.sendMail("331105185@qq.com", "你好", "你好");
    }
}
