package com.shgoods.goods.controller;


import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.service.dto.UserInfoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lyq
 * 用户信息
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserInfoDtoService userInfoDtoService;

    @GetMapping(value = "/info")
    public String info(){

        return "user/userInfo";
    }

    @GetMapping(value = "/allUser")
    public Object allUser(){

        List<UserInfoDto> allUser = userInfoDtoService.findAllUser();

        return allUser;

    }


}
