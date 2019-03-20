package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShOrderGoodsService {

    ResponseVo allByorder(ShOrder shOrder);

}
