package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShOrderMapper {

    public List<ShOrder> allOrder();
}
