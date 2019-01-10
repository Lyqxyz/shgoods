package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 角色相关信息
 * @author lyq
 */
@RequestMapping(value = "/role")
@Controller
public class RoleController {

    @Autowired
    ShRoleService shRoleService;

    @ResponseBody
    @RequestMapping(value = "/info")
    public Object info(HttpServletRequest request){

        PageHelper.startPage(1,3);


        List<ShRole> all = shRoleService.findAll();

        PageInfo<ShRole> shRolePageInfo = new PageInfo<>(all, 3);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.getInfo().put("data",shRolePageInfo);

        return responseVo;
    }

    @RequestMapping(value = "/infoView")
    public String infoView(){


        return "";
    }


}
