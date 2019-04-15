package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShOrderGoodsMapper {

     List<ShGoodsOrder> selectByGoodsOrder(ShGoodsOrder shGoodsOrder);

     Integer shopCarToOrder(ShGoodsOrder shGoodsOrder);

     List<ShGoodsOrder> selectByUser(ShUser shUser);

     Integer updateById(ShGoodsOrder shGoodsOrder);


}
