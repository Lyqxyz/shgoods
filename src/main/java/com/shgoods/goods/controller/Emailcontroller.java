package com.shgoods.goods.controller;

import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.service.EmailService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/email")
public class Emailcontroller {

    @Autowired
    EmailService emailService;

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String mailFrom;


    @ResponseBody
    @GetMapping("/sendCode/{email}")
    public Object sendEmail(@PathVariable String email){

        ResponseVo responseVo = emailService.checkEmail(email.trim());

        return responseVo;
    }

    @ResponseBody
    @GetMapping("/sendCodeForget/{email}")
    public Object sendCodeForget(@PathVariable String email){

        ResponseVo responseVo = emailService.checkEmailForget(email.trim());

        return responseVo;
    }


//    @ResponseBody
//    @GetMapping("/getCode/{email}")
//    public Object gotEmail(@PathVariable String email){
//
//        EmailCode generate = emailService.get(email);
//
//        return generate;
//    }

    @ResponseBody
    @PostMapping("/forget")
    public Object testEmail(@RequestParam("email") String email,
                            @RequestParam("code")String code,
                            @RequestParam("pwd")String pwd){

        ResponseVo responseVo = emailService.forgetPwd(email, code, pwd);

        return responseVo;
    }



}
