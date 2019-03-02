package com.shgoods.goods.mapper;


import com.shgoods.goods.pojo.ShAuthority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 */
@Mapper
public interface ShAuthorityMapper {


    //查询所有权限
    public List<ShAuthority> findAllAuthority();

    //插入权限
    public Integer insertAuthority(ShAuthority shAuthority);

    //更新权限
    public Integer updateAuthority(ShAuthority shAuthority);

    //更新状态
    public Integer forbidAuthority(ShAuthority shAuthority);

    //根据条件筛选
    public List<ShAuthority> finaAuthorityByCondition(ShAuthority shAuthority);

    //检查权限是否可用
    public ShAuthority checkAuthority(ShAuthority shAuthority);

    //检查编号是否重复
    public ShAuthority checkAuthNum(ShAuthority shAuthority);

    //检查名字是否重复
    public ShAuthority checkAuthName(ShAuthority shAuthority);
}
