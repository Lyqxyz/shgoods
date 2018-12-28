package com.shgoods.goods.exception.concroller;


import com.shgoods.goods.exception.RegisteredException;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class RegisteredExceptionController {


    @ResponseBody
    @ExceptionHandler(value = RegisteredException.class)
    public Object regexception(Exception e,HttpServletRequest request){

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setPath(request.getRequestURI());

        responseVo.setMessage(e.getMessage());

        responseVo.setDate(new Date());

        return responseVo;
    }
}
