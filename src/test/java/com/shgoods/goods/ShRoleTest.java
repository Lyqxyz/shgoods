package com.shgoods.goods;


import com.shgoods.goods.mapper.ShRoleMapper;
import com.shgoods.goods.pojo.ShRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShRoleTest {

    @Autowired
    ShRoleMapper shRoleMapper;

    @Test
    public void test1(){


        ShRole shRole = new ShRole();

        shRole.setRoleNum("10");
        shRole.setRoleState(-1);
        shRole.setRoleDes("哈哈哈");
        shRole.setRoleName("角色11");
        Integer integer = shRoleMapper.insertRole(shRole);

        System.out.println(integer);

    }

    @Test
    public void test2(){
        ShRole shRole = new ShRole();
        shRole.setRoleState(-1);
        shRole.setRoleId("97977401056690238");


        shRoleMapper.forbidRole(shRole);

    }

    @Test
    public void test3(){

        ShRole shRole = new ShRole();

        //shRole.setRoleNum("10");

        shRole.setRoleName("角色");

        List<ShRole> all = shRoleMapper.findAllRoleByCondition(shRole);

        all.stream().forEach(System.out::println);
    }

}
