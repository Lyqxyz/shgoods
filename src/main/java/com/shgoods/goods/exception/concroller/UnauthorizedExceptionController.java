package com.shgoods.goods.exception.concroller;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

/**
 * 没有权限异常
 */
@ControllerAdvice
public class UnauthorizedExceptionController {


    @ExceptionHandler(value = {UnauthorizedException.class})
    public String unauthorized(HttpServletRequest request,Exception e){


        System.out.println(e.getMessage());

        request.setAttribute("javax.servlet.error.status_code",401);

        request.setAttribute("message","你没有权限");

        request.setAttribute("code","-1");

        return "forward:/error";

    }
}
