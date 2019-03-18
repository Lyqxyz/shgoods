package com.shgoods.goods.controller;

import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import com.shgoods.goods.service.ShUserRoleService;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.userrole.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "addView")
    public String addView(){

        return "role/addRoleToUser";
    }

    @GetMapping(path = "/forbid/{urId}")
    @ResponseBody
    public Object forbid(@PathVariable(value = "urId") String urId,HttpServletRequest request){

        ShUserRole shUserRole = new ShUserRole();

        shUserRole.setUrId(urId);

        ResponseVo forbid = shUserRoleService.forbid(shUserRole);

        return forbid;

    }


    @ResponseBody
    @PostMapping(path = "/add")
    public Object add(UserRoleVo userRoleVo,HttpServletRequest request){

        ShUserRole shUserRole = new ShUserRole();

        ShRole shRole = new ShRole();

        shRole.setRoleId(userRoleVo.getRid());

        ShUser shUser = new ShUser();

        shUser.setUserId(userRoleVo.getUid());

        shUserRole.setUrRid(shRole);

        shUserRole.setUrUid(shUser);

        ResponseVo add = shUserRoleService.add(shUserRole);

        add.setPath(request.getRequestURI());

        return add;

    }








}
