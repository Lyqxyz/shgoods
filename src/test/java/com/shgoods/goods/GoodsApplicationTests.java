package com.shgoods.goods;

import com.shgoods.goods.mapper.*;
import com.shgoods.goods.pojo.ShAuthorityRole;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.pojo.ShUserRole;
import com.shgoods.goods.service.ShUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsApplicationTests {


    @Autowired
    ShUserService shUserService;

    @Autowired
    ShUserMapper shUserMapper;

    @Autowired
    ShRoleMapper shRoleMapper;

    @Autowired
    ShUserRoleMapper shUserRoleMapper;

    @Autowired
    ShAuthorityMapper shAuthorityMapper;

    @Autowired
    ShAuthorityRoleMapper shAuthorityRoleMapper;
    @Test
    public void contextLoads() {


    }

    @Test
    public void test1(){

        List<ShAuthorityRole> allAuthRole = shAuthorityRoleMapper.findAllAuthRole();

        allAuthRole.stream().forEach(System.out::println);

    }

}
