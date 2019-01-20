package com.shgoods.goods;


import com.shgoods.goods.dto.ClassInfoDto;
import com.shgoods.goods.mapper.dto.ClassInfoDtoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassInfoDtoTest {

    @Autowired
    ClassInfoDtoMapper classInfoDtoMapper;

    @Test
    public void test1(){

        List<ClassInfoDto> all = classInfoDtoMapper.findAll();

        all.stream().forEach(System.out::println);
    }
}
