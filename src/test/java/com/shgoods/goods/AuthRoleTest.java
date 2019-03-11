package com.shgoods.goods;

import com.shgoods.goods.mapper.ShAuthorityRoleMapper;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthRoleTest {

    @Autowired
    ShAuthorityRoleMapper shAuthorityRoleMapper;

    @Test
    public void test1(){

        ShRole shRole = new ShRole();
        shRole.setRoleId("97977401056690237");

        //shRole.setRoleNum("5");

        List<ShAuthorityRole> shAuthorityRoles = shAuthorityRoleMapper.RoleHasAuth(shRole);

        List<ShAuthority> shAuthorities = shAuthorityRoleMapper.RoleNoAuth(shRole);

        shAuthorityRoles.stream().forEach(System.out::println);

        shAuthorities.stream().forEach(System.out::println);
    }
}
