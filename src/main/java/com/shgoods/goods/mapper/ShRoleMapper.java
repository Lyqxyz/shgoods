package com.shgoods.goods.mapper;


import com.shgoods.goods.pojo.ShRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 */
@Mapper
public interface ShRoleMapper {


    //查询所有角色
    public List<ShRole> findAllRole();

    //插入角色
    public Integer insertRole(ShRole shRole);

    //根据条件查询
    public List<ShRole> findAllRoleByCondition(ShRole shRole);

    //根据角色修改
    public Integer updateRole(ShRole shRole);

    //修改角色的状态
    public Integer forbidRole(ShRole shRole);

    //检查角色是否可用
    public ShRole usableRole(ShRole shRole);


}
