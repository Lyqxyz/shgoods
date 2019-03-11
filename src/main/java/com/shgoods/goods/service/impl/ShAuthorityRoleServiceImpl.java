package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShAuthorityRoleMapper;
import com.shgoods.goods.mapper.ShRoleMapper;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShAuthorityRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShAuthorityRoleServiceImpl implements ShAuthorityRoleService {


    @Autowired
    ShAuthorityRoleMapper shAuthorityRoleMapper;

    @Autowired
    ShRoleMapper shRoleMapper;

    @Override
    public ResponseVo Authorization(ShRole shRole) {

        ResponseVo responseVo = new ResponseVo();
        if(shRole!=null&&shRole.getRoleId()!=null){


            ShRole shRole1 = shRoleMapper.selectRoleById(shRole);

            if(shRole1!=null){

                List<ShAuthorityRole> shAuthorityRoles = shAuthorityRoleMapper.RoleHasAuth(shRole);

                List<ShAuthority> shAuthorities = shAuthorityRoleMapper.RoleNoAuth(shRole);

                responseVo.getInfo().put("no",shAuthorities);

                responseVo.getInfo().put("has",shAuthorityRoles);

                responseVo.setCode("1");

                responseVo.setMessage("请求成功");


            }else{

                responseVo.setCode("-1");
                responseVo.setMessage("请求失败");
                responseVo.getErrors().put("errors", Arrays.asList("角色不存在"));

            }


        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("请求失败");
            responseVo.getErrors().put("errors", Arrays.asList("角色id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;



    }
}
