package com.shgoods.goods;


import com.shgoods.goods.mapper.ShUserRoleMapper;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShUserRoleTest {

    @Autowired
    ShUserRoleMapper shUserRoleMapper;

    @Test
    public void test1(){

        List<ShUserRole> allUSerRole = shUserRoleMapper.findAllUSerRole();

        allUSerRole.stream().forEach(System.out::println);

    }

    @Test
    public void test2(){

        ShUser shUser = new ShUser();
        shUser.setUserNum("aaaaaa");
        List<ShRole> noRoleByShUser = shUserRoleMapper.findNoRoleByShUser(shUser);
        noRoleByShUser.stream().forEach(System.out::println);


    }
}
