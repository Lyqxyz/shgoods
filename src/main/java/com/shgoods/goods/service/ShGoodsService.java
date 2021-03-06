package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShGoodsService {


    List<ShGoods> all();

    ResponseVo add(ShGoods shGoods);

    ResponseVo selectByUser(ShUser shUser);

    ResponseVo selectByClass(ShClass shClass);

    ResponseVo selectWithUser(ShGoods shGoods);

    ResponseVo delById(ShGoods shGoods);

    ResponseVo selectWithVar(String id);

    ResponseVo updateGoods(ShGoods shGoods);

    ResponseVo updateState(ShGoods shGoods);


}
