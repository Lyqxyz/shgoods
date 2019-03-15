package com.shgoods.goods.controller;

import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShUserRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/userRole")
public class UserRoleController {

    @Autowired
    ShUserRoleService shUserRoleService;

    @ResponseBody
    @GetMapping(path = "/info/{userNum}")
    public ResponseVo info(@PathVariable(value = "userNum") String userNum, HttpServletRequest request){

        ShUser shUser = new ShUser();

        shUser.setUserNum(userNum);

        ResponseVo info = shUserRoleService.info(shUser);

        info.setPath(request.getRequestURI());

        return info;

    }


}
