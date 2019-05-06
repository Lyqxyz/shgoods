package com.shgoods.goods.exception.concroller;


import com.shgoods.goods.vo.ResponseVo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 授权异常
 */
@ControllerAdvice
public class AuthExceptionController {

    @ExceptionHandler(value = UnauthenticatedException.class)
    public String authException(HttpServletRequest request,Exception e){

        System.out.println(e.getMessage());

        request.setAttribute("javax.servlet.error.status_code",401);

        request.setAttribute("message","你没有被授权");

        request.setAttribute("code","-1");

        return "forward:/error";

    }


//    @ExceptionHandler(value = UnauthenticatedException.class)
//    public String authexception1(HttpServletRequest request){
//
//
//        return "unauthorized/unauthorized";
//
//    }

}
