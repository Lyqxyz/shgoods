package com.shgoods.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class Emailcontroller {

    @ResponseBody
    @GetMapping("/sendCode/{email}")
    public Object sendEmail(@PathVariable String email){


        return null;
    }
}
