package com.shgoods.goods.exception.concroller;


import com.shgoods.goods.exception.LoginException;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author lyq
 * 自定义错误数据
 */
@ControllerAdvice
public class LoginExceptionController {


    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Object handleException(Exception e,HttpServletRequest request){

        ResponseVo responseinfo = responseinfo(e.getMessage());
        responseinfo.setPath(request.getRequestURI());

        responseinfo.setCode("-1");

        responseinfo.setMessage("登录失败");
        return responseinfo;
    }

//    @ExceptionHandler(Exception.class)
//    public String handAllException(Exception e,HttpServletRequest request){
//
//        request.setAttribute("javax.servlet.error.status_code",500);
//        request.setAttribute("message","服务器繁忙");
//        return "forward:/error";
//    }

    public  ResponseVo responseinfo(String errormsg){

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setMessage(errormsg);

        responseVo.setDate(new Date());

        return responseVo;

    }


}
