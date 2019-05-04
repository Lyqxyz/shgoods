package com.shgoods.goods.mapper;


import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShAuthorityRoleMapper {


    //查询所有角色权限
     List<ShAuthorityRole> findAllAuthRole();

    //插入角色权限
     Integer insertAuthRole(ShAuthorityRole shAuthorityRole);

    //更新角色权限
     Integer updateAuthRole(ShAuthorityRole shAuthorityRole);

    //禁用角色权限
     Integer forbidAuthRole(ShAuthorityRole shAuthorityRole);

    //查询角色拥有的权限(不包括删除的)
     List<ShAuthorityRole> RoleHasAuth(ShRole shRole);

    //查询角色没有的权限
     List<ShAuthority> RoleNoAuth(ShRole shRole);

    //查询角色所有权限
     List<ShAuthority> AllAuthByRoles(List<ShRole> shRoles);

    //查询角色是否有次权限
     ShAuthorityRole hasAuth(ShAuthorityRole shAuthorityRole);



}
