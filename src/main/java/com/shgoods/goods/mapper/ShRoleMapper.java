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
     List<ShRole> findAllRole();

    //插入角色
     Integer insertRole(ShRole shRole);

    //根据条件查询
     List<ShRole> findAllRoleByCondition(ShRole shRole);

    //根据角色修改
     Integer updateRole(ShRole shRole);

    //禁用角色的状态
     Integer forbidRole(ShRole shRole);

    //禁用角色的状态
     Integer delRole(ShRole shRole);

    //检查角色是否可用
     ShRole usableRole(ShRole shRole);

     ShRole selectRoleById(ShRole shRole);

     ShRole checkRoleNum(ShRole shRole);

     ShRole checkRoleName(ShRole shRole);

     Integer active(String roleId);

}
