package com.shgoods.goods.controller;


import com.shgoods.goods.service.ShUserService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.RegVo;
import com.shgoods.goods.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lyq
 * 注册
 */

@Slf4j
@Controller
public class RegController {


    @Autowired
    ShUserService shUserService;

    /**
     * 跳转注册页面
     * @return
     */
    @GetMapping(value = "/reg")
    public String registration(){

        return "user/registration";
    }

    /**
     * 注册
     * @param regVo
     * @return
     */
    @ResponseBody
    @PostMapping("/registered")
    public Object registered(@Validated RegVo regVo, BindingResult bindingResult, HttpServletRequest request){


        if(bindingResult.hasErrors()){

//            System.out.println("进来了");
//            ResponseVo responseVo = new ResponseVo();
//            Map<String, List<String>> errors =BindingErrorUtil.handlerErrors(bindingResult);
//            responseVo.setCode("-1");
//            responseVo.setDate(new Date());
//            responseVo.setMessage("注册失败");
//            responseVo.setPath(request.getRequestURI());
//            responseVo.getErrors().put("AllError",errors);

            ResponseVo responseVo = BindingErrorUtil.common("注册失败", request.getRequestURL().toString(), bindingResult);

            return responseVo;
        }else{

            ResponseVo register = shUserService.register(regVo, request);

            return register;

        }


    }


}
