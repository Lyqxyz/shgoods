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


    //查询所有的用户
    public List<ShUser> findAllUser();

    //用户登录
    public ShUser login(ShUser shUser);

    //用户注册
    public Integer register(ShUser shUser);

    //根据条件查询
    public List<ShUser> findByConditions(ShUser shUser);

    //登录之后更新状态
    public Integer afterLogin(ShUser shUser);

    //注销之后
    public Integer afterLogout(ShUser shUser);

    //检查学号是否重复
    public ShUser checkShUserNum(ShUser shUser);

    //检查电话是否重复
    public ShUser checkShUserPhone(ShUser shUser);

    //检查邮箱是否重复
    public ShUser checkShUserEmail(ShUser shUser);


}
