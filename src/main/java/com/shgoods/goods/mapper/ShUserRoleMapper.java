package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lyq
 */
@Mapper
public interface ShUserRoleMapper {


    //查询用户拥有的角色
     List<ShUserRole> findAllRoleByShUser(ShUser shUser);

    //查询用户没有的角色
     List<ShRole> findNoRoleByShUser(ShUser shUser);

    //查询所有用户所拥有的角色
     List<ShUserRole> findAllUSerRole();

    //禁用或删除用户角色 0  1 -1
     Integer forbidUserRole(ShUserRole shUserRole);

    //更新用户角色
     Integer updateUserRole(ShUserRole shUserRole);

    //更新用户角色状态
     Integer updateState(ShUserRole shUserRole);

    //检查用户是否有这个角色
     ShUserRole isUserHasRole(ShUserRole shUserRole);

    //插入用户角色
     Integer insertUserRole(ShUserRole shUserRole);

    //查询用户拥有的角色
     ShUser findAllRole(ShUser shUser);


     Integer del(String urid);


}
