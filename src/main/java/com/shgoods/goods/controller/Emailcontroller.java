package com.shgoods.goods.controller;

import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.service.EmailService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/email")
public class Emailcontroller {

    @Autowired
    EmailService emailService;

    @ResponseBody
    @GetMapping("/sendCode/{email}")
    public Object sendEmail(@PathVariable String email){

        ResponseVo responseVo = emailService.checkEmail(email.trim());

        return responseVo;
    }

    @ResponseBody
    @GetMapping("/getCode/{email}")
    public Object gotEmail(@PathVariable String email){

        EmailCode generate = emailService.get(email);

        return generate;
    }



}
