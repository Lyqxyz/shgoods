package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShAuthorityService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.authority.AddAuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/addView")
    public String addView(){

        return "authority/addAuthority";
    }

    @ResponseBody
    @GetMapping(path = "/forbid/{id}")
    public Object forbid(@PathVariable(value = "id") String id,HttpServletRequest request){


        ShAuthority shAuthority = new ShAuthority();

        shAuthority.setAuthorityState(0);

        shAuthority.setAuthorityId(id);

        ResponseVo forbid = shAuthorityService.forbid(shAuthority);

        forbid.setPath(request.getRequestURI());

        forbid.setDate(new Date());

        return forbid;
    }
    @ResponseBody
    @GetMapping(path = "/delete/{id}")
    public Object del(@PathVariable(value = "id") String id,HttpServletRequest request){


        ShAuthority shAuthority = new ShAuthority();

        shAuthority.setAuthorityState(-1);

        shAuthority.setAuthorityId(id);

        ResponseVo forbid = shAuthorityService.del(shAuthority);

        forbid.setPath(request.getRequestURI());

        forbid.setDate(new Date());

        return forbid;
    }


    @GetMapping(value = "/infoView")
    public String infoView(){

        return "authority/AuthorityInfo";

    }


    @ResponseBody
    @GetMapping(path = "/info/{pageNum}/{pageSize}")
    public Object info(@PathVariable(value = "pageNum")Integer pageNum,
                       @PathVariable(value = "pageSize")Integer pageSize,
                       HttpServletRequest request){


        PageHelper.startPage(pageNum,pageSize);

        List<ShAuthority> all = shAuthorityService.info();

        PageInfo<ShAuthority> ShAuthorityInfo = new PageInfo<>(all, 3);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.getInfo().put("data",ShAuthorityInfo);

        return responseVo;


    }


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


    @ResponseBody
    @GetMapping("/active/{authId}")
    public Object active(@PathVariable String authId,HttpServletRequest request){

        ShAuthority shAuthority = new ShAuthority();

        shAuthority.setAuthorityState(1);

        shAuthority.setAuthorityId(authId);

        ResponseVo forbid = shAuthorityService.active(shAuthority);

        forbid.setPath(request.getRequestURI());

        forbid.setDate(new Date());

        return forbid;

    }

}
