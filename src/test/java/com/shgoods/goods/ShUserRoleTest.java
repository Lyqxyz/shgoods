package com.shgoods.goods;


import com.alibaba.fastjson.JSON;
import com.shgoods.goods.bean.UserRoleAuth;
import com.shgoods.goods.mapper.ShAuthorityRoleMapper;
import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShUserRoleTest {

    @Autowired
    ShUserRoleMapper shUserRoleMapper;

    @Autowired
    ShAuthorityRoleMapper shAuthorityRoleMapper;

    @Test
    public void test1(){

        List<ShUserRole> allUSerRole = shUserRoleMapper.findAllUSerRole();

        allUSerRole.stream().forEach(System.out::println);
    }
    @Test
    public void test2(){

        ShUser shUser = new ShUser();
        shUser.setUserNum("12002");
        List<ShUserRole> allRoleByShUser = shUserRoleMapper.findAllRoleByShUser(shUser);
        allRoleByShUser.stream().forEach(System.out::println);
    }





    @Test
    public void test3(){

        ShUser shUser = new ShUser();

        shUser.setUserNum("12004");

        ShUser allRole = shUserRoleMapper.findAllRole(shUser);

        List<ShAuthority> shAuthorities = shAuthorityRoleMapper.AllAuthByRoles(allRole.getShRoles());

        UserRoleAuth userRoleAuth = new UserRoleAuth();

        userRoleAuth.setShAuthorities(shAuthorities);

        userRoleAuth.setShRoles(allRole.getShRoles());

        userRoleAuth.setShUser(shUser);


        String s = JSON.toJSONString(userRoleAuth);

        System.out.println(s);

    }

}
