package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShGoodsService {


    List<ShGoods> all();

    ResponseVo add(ShGoods shGoods);
}
