package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShOrderMapper {

     List<ShOrder> allOrder();

     Integer add(ShOrder shOrder);




}
