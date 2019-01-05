package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShUserService;
import com.shgoods.goods.service.dto.UserInfoDtoService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.user.UserAddVo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author lyq
 * 用户信息
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    ShUserService shUserService;

    @Autowired
    UserInfoDtoService userInfoDtoService;

    @GetMapping(value = "/info")
    public String info(){

        return "user/userInfo";
    }

    @ResponseBody
    @GetMapping(value = "/users/{pageNum}/{pageSize}")
    public Object allUser(@PathVariable(value = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize, HttpServletRequest request){


        PageHelper.startPage(pageNum, pageSize);

        List<UserInfoDto> allUser = userInfoDtoService.findAllUser();

        PageInfo page = new PageInfo(allUser,10);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.setPath(request.getRequestURI());

        responseVo.setCode("1");

        responseVo.getInfo().put("data",page);

        return responseVo;

    }

    @ResponseBody
    @GetMapping(value = "/forbid/{userId}")
    public Object forbidUser(@PathVariable(value = "userId") String userId,HttpServletRequest request){

        ShUser shUser = new ShUser();

        shUser.setUserId(userId);

        ResponseVo responseVo = shUserService.forbidUser(shUser);

        responseVo.setPath(request.getRequestURI());

        return  responseVo;

    }
    @RequiresRoles(value = {"user","admin"})
//
    @ResponseBody
    @GetMapping(value = "/delete/{userId}")
    public Object delUser(@PathVariable(value = "userId") String userId,HttpServletRequest request){

        ShUser shUser = new ShUser();

        shUser.setUserId(userId);

        ResponseVo responseVo = shUserService.delUser(shUser);

        responseVo.setPath(request.getRequestURI());

        return  responseVo;

    }


    @ResponseBody
    @PostMapping("/add")
    public Object addUser(@Validated UserAddVo userAddVo, BindingResult result,HttpServletRequest request){


        ShUser shUser = new ShUser();

        BeanUtils.copyProperties(userAddVo,shUser);

        ResponseVo responseVo=null;

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);
        }else {

            responseVo = shUserService.addUser(shUser);

        }
        System.out.println(shUser);
        return responseVo;
    }


}
