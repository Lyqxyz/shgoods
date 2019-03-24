package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShGoodsMapper {

    Integer add(ShGoods shGoods);

    ShGoods has(ShGoods shGoods);

}
