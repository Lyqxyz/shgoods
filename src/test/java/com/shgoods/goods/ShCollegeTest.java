package com.shgoods.goods;


import com.shgoods.goods.mapper.ShCollegeMapper;
import com.shgoods.goods.pojo.ShCollege;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShCollegeTest {

    @Autowired
    ShCollegeMapper shCollegeMapper;

    @Test
    public void test(){

        List<ShCollege> allCollege = shCollegeMapper.findAllCollege();

        allCollege.stream().forEach(System.out::println);

    }
}
