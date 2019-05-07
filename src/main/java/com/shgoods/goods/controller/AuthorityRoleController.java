package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShAuthorityRoleService;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.authrole.AuthRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/authRole")
public class AuthorityRoleController {

    @Autowired
    ShAuthorityRoleService shAuthorityRoleService;

    @ResponseBody
    @GetMapping(path = "/info/{roleId}")
    public Object infoByRole(@PathVariable(value = "roleId") String roleId, HttpServletRequest request){

        ShRole shRole = new ShRole();

        shRole.setRoleId(roleId);

        ResponseVo authorization = shAuthorityRoleService.Authorization(shRole);


        authorization.setPath(request.getRequestURI());
        return authorization;

    }

    @GetMapping(path = "/addView")
    public String addView(){

        return "authority/addAuthToRole";
    }


    @GetMapping(path = "/forbid/{arId}")
    @ResponseBody
    public Object forbid(@PathVariable(value = "arId") String arId,HttpServletRequest request){


        ResponseVo forbid = shAuthorityRoleService.del(arId);

        return forbid;

    }


    @ResponseBody
    @PostMapping(path = "/add")
    public Object add(AuthRoleVo authRoleVo,HttpServletRequest request){

        ShAuthorityRole shAuthorityRole = new ShAuthorityRole();

        ShRole shRole = new ShRole();

        shRole.setRoleId(authRoleVo.getRid());

        ShAuthority shAuthority = new ShAuthority();

        shAuthority.setAuthorityId(authRoleVo.getAid());

        shAuthorityRole.setArAid(shAuthority);

        shAuthorityRole.setArRid(shRole);

        ResponseVo add = shAuthorityRoleService.add(shAuthorityRole);

        add.setPath(request.getRequestURI());

        return add;
    }

}
