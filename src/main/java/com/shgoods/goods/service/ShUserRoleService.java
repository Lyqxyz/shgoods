package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import com.shgoods.goods.vo.ResponseVo;

public interface ShUserRoleService {

    ResponseVo info(ShUser shUser);

    ResponseVo add(ShUserRole shUserRole);

    ResponseVo forbid(ShUserRole shUserRole);

    ResponseVo del(String urid);
}
