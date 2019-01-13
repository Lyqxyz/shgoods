package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShRoleService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.role.RoleAddVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
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
    @RequestMapping(value = "/info/{pageNum}/{pageSize}")
    public Object info(@PathVariable(value = "pageNum") Integer pageNum,
                       @PathVariable(value = "pageSize") Integer pageSize,
                       HttpServletRequest request){

        PageHelper.startPage(pageNum,pageSize);

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


        return "/role/RoleInfo";
    }

    @RequestMapping(value = "/addView")
    public String addView(){

        return "role/addRole";
    }


    @ResponseBody
    @GetMapping(value = "/forbid/{roleId}")
    public Object forbidUser(@PathVariable(value = "roleId") String roleId,HttpServletRequest request){

        ShRole shRole = new ShRole();

        shRole.setRoleId(roleId);

        ResponseVo responseVo = shRoleService.forbidRole(shRole);

        responseVo.setPath(request.getRequestURI());

        return  responseVo;

    }


    @ResponseBody
    @GetMapping(value = "/delete/{roleId}")
    public Object delUser(@PathVariable(value = "roleId") String roleId,HttpServletRequest request){

        ShRole shRole = new ShRole();

        shRole.setRoleId(roleId);

        ResponseVo responseVo = shRoleService.delRole(shRole);


        responseVo.setPath(request.getRequestURI());

        return  responseVo;


    }





    @PostMapping(value = "/add")
    @ResponseBody
    public Object addRole(@Validated RoleAddVo roleAddVo, BindingResult bindingResult,HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {

        ShRole shRole = new ShRole();

        BeanUtils.copyProperties(roleAddVo,shRole);

        shRole.setRoleState(1);

        ResponseVo responseVo=null;

        if(bindingResult.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), bindingResult);

        }else{

            responseVo = shRoleService.addRole(shRole);

        }
        responseVo.setPath(request.getRequestURI());
        return responseVo;

    }



}
