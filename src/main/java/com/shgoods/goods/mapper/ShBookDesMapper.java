package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShBookDescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShBookDesMapper {

    Integer add(ShBookDescription shBookDescription);

}
