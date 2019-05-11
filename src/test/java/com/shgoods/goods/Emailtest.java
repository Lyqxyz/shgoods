package com.shgoods.goods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Emailtest {

     @Autowired
     JavaMailSender mailSender;

     @Value("${spring.mail.username}")
     String mailFrom;

    @Test
    public void test1(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("测试邮件服务");
        message.setText("这是内容123");
        message.setTo("lu951384850@163.com");
        message.setFrom(mailFrom);
        mailSender.send(message);

    }
}
