package com.shgoods.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/shgoods")
    public String index(){

        return "index/index";
    }


}
