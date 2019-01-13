package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShRoleMapper;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShRoleService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShRoleServiceImpl implements ShRoleService {



    @Autowired
    ShRoleMapper shRoleMapper;

    @Override
    public List<ShRole> findAll() {
        List<ShRole> allRole = shRoleMapper.findAllRole();
        return allRole;
    }

    @Override
    public ResponseVo forbidRole(ShRole shRole) {

        ResponseVo responseVo = new ResponseVo();
        if(shRole!=null&&shRole.getRoleId()!=null){

            Integer integer = shRoleMapper.forbidRole(shRole);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("禁用成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是禁用状态");
                responseVo.getErrors().put("errors",Arrays.asList("用户已经是禁用状态"));
            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("禁用失败");
            responseVo.getErrors().put("errors", Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;

    }

    @Override
    public ResponseVo delRole(ShRole shRole) {

        ResponseVo responseVo = new ResponseVo();
        if(shRole!=null&&shRole.getRoleId()!=null){

            Integer integer = shRoleMapper.delRole(shRole);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("删除成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是删除状态");
                responseVo.getErrors().put("errors",Arrays.asList("用户已经是删除状态"));
            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("禁用失败");
            responseVo.getErrors().put("errors", Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;
    }


    @Override
    public ResponseVo addRole(ShRole shRole) {

        List<String> errors = this.checkAttrs(shRole);

        ResponseVo responseVo= new ResponseVo();

        responseVo.setDate(new Date());

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");
        }else {

            Integer integer = shRoleMapper.insertRole(shRole);

            responseVo.setCode("1");

            responseVo.setMessage("添加成功");

        }

        return responseVo;
    }

    @Override
    public List<String> checkAttrs(ShRole shRole) {

        List<String> errors = new ArrayList<>();


        ShRole shRole1 = shRoleMapper.checkRoleNum(shRole);

        ShRole shRole2 = shRoleMapper.checkRoleName(shRole);


        if(!Objects.isNull(shRole1)){
            errors.add("编号已经存在了");
        }
        if (!Objects.isNull(shRole2)){
            errors.add("角色名已经存在了");
        }
        return errors;
    }
}
