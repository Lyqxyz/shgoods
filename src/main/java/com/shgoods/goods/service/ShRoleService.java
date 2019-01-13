package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShRoleService {

   public List<ShRole> findAll();

   public ResponseVo forbidRole(ShRole shRole);

   public ResponseVo delRole(ShRole shRole);

   public ResponseVo addRole(ShRole shRole);

   public List<String> checkAttrs(ShRole shRole);

}
