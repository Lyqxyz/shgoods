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

    public Integer addClass(ShClass shClass);

    public List<ShClass> withoutParentClass();

    public ShClass checkClassNum(ShClass shClass);

    public ShClass checkClassName(ShClass shClass);

    public List<ShClass> selectClassByPid(ShClass shClass);

}
