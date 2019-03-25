package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ShGoodsMapper {

    Integer add(ShGoods shGoods);

    ShGoods has(ShGoods shGoods);

    List<ShGoods> all();

}
