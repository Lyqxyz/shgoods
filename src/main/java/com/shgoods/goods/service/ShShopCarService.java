package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

public interface ShShopCarService {

     List<ShShopCar> all();

     ResponseVo del(ShShopCar shShopCar);

     ResponseVo selectByUser(ShUser shUser);

}
