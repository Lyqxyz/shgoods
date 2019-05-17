package com.shgoods.goods.interceptor;

import com.shgoods.goods.pojo.ShUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        ShUser user =(ShUser) session.getAttribute("user");


        if(Objects.isNull(user)){

            response.sendRedirect("/login");

            return false;
        }

        return true;
    }

}
