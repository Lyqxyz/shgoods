package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShShopCarService {

    public List<ShShopCar> all();

    public ResponseVo del(ShShopCar shShopCar);
}
