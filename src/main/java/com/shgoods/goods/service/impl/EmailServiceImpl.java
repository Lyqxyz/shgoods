package com.shgoods.goods.service.impl;

import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.mapper.ShUserMapper;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.EmailService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String mailFrom;

    @Autowired
    ShUserMapper shUserMapper;


    @Async
    @Override
    public void sendEmail(String to, String subject, String text) {

        log.info("发送邮件："+to);

        EmailCode generate = this.generate(to);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(subject);

        message.setText(generate.getCode());

        message.setTo(to);

        message.setFrom(mailFrom);

        mailSender.send(message);

    }

    //@CachePut(cacheNames = "#email")
    @Override
    public EmailCode generate(String email) {

        EmailCode emailCode = new EmailCode();

        emailCode.setEmail(email);

        emailCode.setLocalDateTime(LocalDateTime.now());

        emailCode.setCode(EmailCode.random());

        return emailCode;
    }

    @Override
    @Cacheable(cacheNames = "#email")
    public EmailCode get(String email) {

        EmailCode emailCode = new EmailCode();

        return emailCode;
    }

    @Override
    public ResponseVo checkEmail(String email) {

        ShUser shUser = new ShUser();

        shUser.setUserEmail(email);

        ShUser shUser1 = shUserMapper.checkShUserEmail(shUser);

        if(Objects.isNull(shUser1)){

            ResponseVo ok = ResponseUtil.isOk();

            ok.setMessage("已发送至邮箱");

            this.sendEmail(email,"注册码","");

            return ok;

        }else {

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("邮箱已被注册");

            return error;
        }
    }


}
