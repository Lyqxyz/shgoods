package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.service.ShAuthorityService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.authority.AddAuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lyq
 * 权限api
 */
@Controller
@RequestMapping(path = "/auth")
public class AuthorityController {

    @Autowired
    ShAuthorityService shAuthorityService;

    @ResponseBody
    @PostMapping(path = "/add")
    public Object add(@Validated AddAuthVo addAuthVo, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){

            ResponseVo responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

            responseVo.setPath(request.getRequestURI());

            return responseVo;

        }else{

            ShAuthority shAuthority = new ShAuthority();

            shAuthority.setAuthorityName(addAuthVo.getName());

            shAuthority.setAuthorityNum(addAuthVo.getNum());

            shAuthority.setAuthorityDes(addAuthVo.getDes());

            shAuthority.setAuthorityState(1);

            ResponseVo add = shAuthorityService.add(shAuthority);

            add.setDate(new Date());

            add.setPath(request.getRequestURI());

            return add;
        }

    }



}
