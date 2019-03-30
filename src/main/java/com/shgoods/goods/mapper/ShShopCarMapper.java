package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShShopCarMapper {


     List<ShShopCar> allShopCar();

     Integer del(ShShopCar shShopCar);

     List<ShShopCar> selectByUser(ShUser shUser);

}
