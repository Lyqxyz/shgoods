package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShOrderMapper {

     List<ShOrder> allOrder();

     Integer add(ShOrder shOrder);

     List<ShOrder> searchByUser(ShUser shUser);

     Integer updateIsPay(ShOrder shOrder);

     Integer updateRecv(ShOrder shOrder);

     Integer delOrder(ShOrder shOrder);

}
