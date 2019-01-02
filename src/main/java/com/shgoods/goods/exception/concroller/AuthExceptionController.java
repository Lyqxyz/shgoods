package com.shgoods.goods.exception.concroller;


import com.shgoods.goods.vo.ResponseVo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class AuthExceptionController {

    @ResponseBody
    @ExceptionHandler(value = UnauthenticatedException.class)
    public Object authexception(HttpServletRequest request){

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setDate(new Date());

        responseVo.setMessage("没有权限");

        responseVo.setPath(request.getRequestURI());

        return responseVo;

    }

}
