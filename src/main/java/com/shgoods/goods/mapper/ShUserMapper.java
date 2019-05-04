package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.List;

/**
 * @author lyq
 */
@Mapper
public interface ShUserMapper {

    //用户登录
     ShUser login(ShUser shUser);

    //用户注册
     Integer register(ShUser shUser);

    //根据条件查询
     List<ShUser> findByConditions(ShUser shUser);

    //登录之后更新状态
     Integer afterLogin(ShUser shUser);

    //注销之后
     Integer afterLogout(ShUser shUser);

    //检查学号是否重复
     ShUser checkShUserNum(ShUser shUser);

    //检查电话是否重复
     ShUser checkShUserPhone(ShUser shUser);

    //检查邮箱是否重复
     ShUser checkShUserEmail(ShUser shUser);

    //禁止用户
     Integer forbidUser(ShUser shUser);

    //删除用户
     Integer delUser(ShUser shUser);

    //恢复用户(除删除的用户)
     Integer restoreUser(ShUser shUser);

    //增加用户
     Integer addUser(ShUser shUser);

     ShUser hasUser(ShUser shUser);

     Integer updatePhoto(ShUser shUser);



}
