package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShShopCarMapper {


     List<ShShopCar> allShopCar();

     Integer del(ShShopCar shShopCar); //逻辑删除

     List<ShShopCar> selectByUser(ShUser shUser);

     Integer add(ShShopCar shShopCar);

     ShShopCar has(ShShopCar shShopCar);

     Integer updateShopCar(ShShopCar shShopCar);

     Integer delShopCar(ShShopCar shShopCar); //真实删除


}
