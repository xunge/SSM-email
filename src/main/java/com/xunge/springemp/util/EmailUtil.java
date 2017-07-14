package com.xunge.springemp.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by xunge on 2017/7/13.
 */
public class EmailUtil {
    private MailSender mailSender;
    private SimpleMailMessage mailMessage;

    public EmailUtil() {
    }

    public void sendMail(String adressTo, String code) {

        String text = "这是一封激活邮件,激活请点击以下链接 http://localhost:8080/ssm/active?code=" + code;
        SimpleMailMessage message = new SimpleMailMessage(mailMessage);// 设置email内容,
        message.setTo(adressTo);
        message.setText(text);

        mailSender.send(message);

    }

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public SimpleMailMessage getMailMessage() {
        return mailMessage;
    }

    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }
}
