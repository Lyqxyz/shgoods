package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShRoleService {

    List<ShRole> findAll();

    ResponseVo forbidRole(ShRole shRole);

    ResponseVo delRole(ShRole shRole);

    ResponseVo addRole(ShRole shRole);

    List<String> checkAttrs(ShRole shRole);

    ResponseVo active(String roleId);


}
