package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShCollege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 * 学院信息
 */

@Mapper
public interface ShCollegeMapper {

    public List<ShCollege> findAllCollege();




}
