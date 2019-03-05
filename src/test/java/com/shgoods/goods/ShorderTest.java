package com.shgoods.goods;


import com.shgoods.goods.mapper.ShOrderMapper;
import com.shgoods.goods.pojo.ShOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShorderTest {


    @Autowired
    ShOrderMapper shOrderMapper;
    @Test
    public void test(){

        List<ShOrder> all = shOrderMapper.allOrder();


        all.stream().forEach(System.out::println);

    }
}
