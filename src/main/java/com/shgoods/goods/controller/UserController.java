package com.shgoods.goods.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.service.dto.UserInfoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @GetMapping(value = "/allUser/{pageNum}/{pageSize}")
    public Object allUser(@PathVariable(value = "pageNum") Integer pageNum,@PathVariable(name = "pageSize") Integer pageSize){


        PageHelper.startPage(pageNum, pageSize);

        List<UserInfoDto> allUser = userInfoDtoService.findAllUser();
        PageInfo page = new PageInfo(allUser,10);



        return page;

    }


}
