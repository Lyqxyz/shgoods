package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 * 收集分类数据
 */
@Mapper
public interface ShClassMapper {

     Integer addClass(ShClass shClass);

     List<ShClass> withoutParentClass();

     ShClass checkClassNum(ShClass shClass);

     ShClass checkClassName(ShClass shClass);

     List<ShClass> selectClassByPid(ShClass shClass);

     List<ShClass> withParentClass();

}
