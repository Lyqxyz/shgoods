package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShUserMapper;
import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.*;
import com.shgoods.goods.service.ShUserRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ShUserRoleServiceImpl implements ShUserRoleService {

    @Autowired
    ShUserRoleMapper shUserRoleMapper;

    @Autowired
    ShUserMapper shUserMapper;

    @Override
    public ResponseVo info(ShUser shUser){

        ResponseVo responseVo = new ResponseVo();
        if(shUser!=null&&shUser.getUserNum()!=null){

            ShUser shUser1 = shUserMapper.hasUser(shUser);

            if(shUser1!=null){

                List<ShRole> noRoleByShUser = shUserRoleMapper.findNoRoleByShUser(shUser);

                List<ShUserRole> allRoleByShUser = shUserRoleMapper.findAllRoleByShUser(shUser);

                responseVo.getInfo().put("no",noRoleByShUser);

                responseVo.getInfo().put("has",allRoleByShUser);

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
            responseVo.getErrors().put("errors", Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;


    }

    @Override
    public ResponseVo add(ShUserRole shUserRole) {

        ResponseVo responseVo = new ResponseVo();

        if(Objects.isNull(shUserRole)||Objects.isNull(shUserRole.getUrRid().getRoleId())||
                Objects.isNull(shUserRole.getUrUid().getUserId())){

            responseVo.setCode("-1");
            responseVo.setMessage("请求失败");

        }else{

            ShUserRole userHasRole = shUserRoleMapper.isUserHasRole(shUserRole);

            if(Objects.isNull(userHasRole)){

                Integer integer = shUserRoleMapper.insertUserRole(shUserRole);

                responseVo.setCode("1");
                responseVo.setMessage("请求成功");

            }else {

                responseVo.setCode("-1");
                responseVo.setMessage("不可重复添加");
            }

        }

        responseVo.setDate(new Date());

        return responseVo;

    }
}
