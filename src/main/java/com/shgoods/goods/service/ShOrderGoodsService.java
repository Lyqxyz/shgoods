package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShOrderGoodsService {

    ResponseVo allByorder(ShOrder shOrder);

    ResponseVo addOrderGoods(ShGoodsOrder shGoodsOrder);

    ResponseVo addOrderGoods(ShOrder shOrder,List<ShShopCar> shShopCars);

    ResponseVo selectByOrderGoods(ShGoodsOrder shGoodsOrder);

    ResponseVo selectByUser(ShUser shUser);

    ResponseVo updataById(ShGoodsOrder shGoodsOrder);

    ResponseVo resetById(ShGoodsOrder shGoodsOrder);

    ResponseVo del(String id);

}
