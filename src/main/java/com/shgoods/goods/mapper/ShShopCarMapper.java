package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShShopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShShopCarMapper {


    public List<ShShopCar> allShopCar();

    public Integer del(ShShopCar shShopCar);


}
