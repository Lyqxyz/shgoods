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
        return responseinfo;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handAllException(Exception e,HttpServletRequest request){
        ResponseVo responseinfo = responseinfo("服务器错误,请稍后再试!");
        responseinfo.setPath(request.getRequestURI());
        return responseinfo;
    }

    public  ResponseVo responseinfo(String errormsg){

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setMessage(errormsg);

        responseVo.setDate(new Date());

        return responseVo;

    }


}
