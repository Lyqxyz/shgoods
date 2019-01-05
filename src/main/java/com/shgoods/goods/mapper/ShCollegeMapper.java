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

    /**
     * 查询学院的信息(包括已禁用和删除)
     * @return
     */
    public List<ShCollege> findAllCollege();

    /**
     * 查询学院的信息(不包括已禁用和删除)
     * @return
     */
    public List<ShCollege> findUsefulCollege();

    /**
     * 检查学院编号是否重复
     * @param shCollege
     * @return
     */
    public ShCollege checkCollegeNum(ShCollege shCollege);


}
