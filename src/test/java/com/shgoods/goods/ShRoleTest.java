package com.shgoods.goods;


import com.shgoods.goods.mapper.ShRoleMapper;
import com.shgoods.goods.pojo.ShRole;
import org.junit.Assert;
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

    @Test
    public void test4(){

        List<ShRole> allRole = shRoleMapper.findAllRole();

        allRole.stream().forEach(System.out::println);

    }

    @Test
    public void test5(){
        ShRole shRole = new ShRole();
        shRole.setRoleName("角色1");

        shRole.setRoleNum("1");
        ShRole shRole1 = shRoleMapper.checkRoleName(shRole);

        ShRole shRole2 = shRoleMapper.checkRoleNum(shRole);

        System.out.println(shRole1);
        System.out.println(shRole2);

    }

}
