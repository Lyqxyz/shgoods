package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsDescription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShGoodsDesMapper {


  List<ShGoodsDescription> search(ShGoods shGoods);

  Integer add(ShGoodsDescription shGoodsDescription);

}
