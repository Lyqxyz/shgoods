package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShOrderService {


     List<ShOrder> info();

     ResponseVo add(ShOrder shOrder, List<ShShopCar> shShopCars);

}
