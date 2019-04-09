package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShBookDesMapper {

    Integer add(ShBookDescription shBookDescription);

    List<ShBookDescription> search(ShBook shBook);

    Integer del(ShBookDescription shBookDescription);

    List<ShBookDescription> all();

    List<ShBookDescription> selectByClass(ShClass shClass);

}
