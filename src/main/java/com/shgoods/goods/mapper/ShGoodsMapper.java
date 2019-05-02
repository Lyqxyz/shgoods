package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ShGoodsMapper {

    Integer add(ShGoods shGoods);

    ShGoods has(ShGoods shGoods);

    List<ShGoods> all();

    List<ShGoods> selectByUser(ShUser shUser);

    Integer del(ShGoods shGoods);

    List<ShGoodsDescription> selectByClass(ShClass shClass);

    ShGoods selectById(ShGoods shGoods);

    ShGoods selectWithUser(ShGoods shGoods);

    Integer updateState(ShGoods shGoods);

    ShGoods selectWithAllVar(String goodsId);

    Integer updateGoods(ShGoods shGoods);

}
