package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.vo.ResponseVo;
import java.util.List;



public interface ShOrderService {

     List<ShOrder> info();

     ResponseVo add(ShOrder shOrder, List<ShShopCar> shShopCars);

     ResponseVo selectByUser(ShUser shUser);

     ResponseVo updateIsPay(ShOrder shOrder);

     ResponseVo updateRecv(ShOrder shOrder);

     ResponseVo delOrder(ShOrder shOrder);
}
