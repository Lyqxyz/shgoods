package com.shgoods.goods.controller;

import com.shgoods.goods.bean.Email;
import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.service.EmailService;
import com.shgoods.goods.service.ShUserService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.util.ResponseUtil;
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

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lyq
 * 注册
 */

@Slf4j
@Controller
public class RegController {


    @Autowired
    ShUserService shUserService;

    @Autowired
    EmailService emailService;


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

            ResponseVo responseVo = BindingErrorUtil.common("注册失败", request.getRequestURL().toString(), bindingResult);

            return responseVo;

        }else{

            Email email = new Email();

            email.setEmailAddress(regVo.getEmail());

            email.setEmailType(EmailCode.EMAIL_TYPE_RER);

            email.setEmailCode(regVo.getCode());

            Email email1 = emailService.get(email);

            if(Objects.isNull(email1)){

                ResponseVo error = ResponseUtil.isError();

                error.setMessage("请点在发送至邮箱");

                return error;
            }

            LocalDateTime now = LocalDateTime.now();

            LocalDateTime emailUpdate = email1.getEmailUpdate();

            LocalDateTime localDateTime = emailUpdate.plusSeconds(EmailCode.EXPIRE_SECOND);

            boolean after = now.isAfter(localDateTime);

            if(after){
                ResponseVo error = ResponseUtil.isError();

                error.setMessage("验证码已失效");
                return error;
            }

            if(!email1.getEmailCode().equalsIgnoreCase(regVo.getCode())){

                ResponseVo error = ResponseUtil.isError();

                error.setMessage("验证码不正确");

                return error;
            }

            ResponseVo register = shUserService.register(regVo, request);

            return register;

        }


    }


}
