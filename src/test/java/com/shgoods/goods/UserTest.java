package com.shgoods.goods;


import com.shgoods.goods.mapper.ShUserMapper;
import com.shgoods.goods.pojo.ShUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    ShUserMapper shUserMapper;

    @Test
    public void test(){

        ShUser shUser =new ShUser();

        shUser.setUserId("");

        List<ShUser> byConditions = shUserMapper.findByConditions(shUser);

        System.out.println(byConditions.size());

    }

}
