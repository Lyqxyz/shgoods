package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShAuthorityRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
