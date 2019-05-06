package com.shgoods.goods.controller;

import com.shgoods.goods.exception.LoginException;
import com.shgoods.goods.service.ShUserService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.LoginVo;
import com.shgoods.goods.vo.ResponseVo;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Controller
public class LoginController {


    @Autowired
    ShUserService shUserService;


    @GetMapping(value = "/login")
    public String login(Model model, HttpSession session) {

        Subject currentUser = SecurityUtils.getSubject();

        if(currentUser.isAuthenticated()){

            return "redirect:/index";
        }

        String token = UUID.randomUUID().toString();

        session.setAttribute("token", token);

        model.addAttribute("token", token);

        return "user/login";
    }

    @ResponseBody
    @PostMapping(value = "/check", params = "token")
    public Object check(@Validated LoginVo loginVo, BindingResult bindingResult, HttpSession session, HttpServletRequest request) {

        String token = (String) session.getAttribute("token");
        if (token == null) {

            throw new LoginException("非法登录");
        }
        if (!loginVo.getToken().equals(token)) {

            throw new LoginException("非法登录");
        }
        if (bindingResult.hasErrors()) {
            ResponseVo responseVo = new ResponseVo();
            Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(bindingResult);
            responseVo.setCode("-1");
            responseVo.setDate(new Date());
            responseVo.setMessage("登录失败,请重新登录");
            responseVo.setPath(request.getRequestURI());
            responseVo.getErrors().put("AllError",errors);
            return responseVo;
        }else{
            ResponseVo login = shUserService.login(loginVo, request, session);
            return login;
        }
    }
    @GetMapping(value = "/index")
    public String index() {

        return "user/index";
    }

    @GetMapping(value = "/logout")
    public String logout(){

        return "redirect:/login";
    }

    @ResponseBody
    @PostMapping(path = "/indexLogin")
    public Object indexLogin(@Validated LoginVo loginVo,HttpServletRequest request,HttpSession session){


        ResponseVo login = shUserService.indexLogin(loginVo, request, session);

        return login;

    }

}
