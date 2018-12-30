package com.shgoods.goods;


import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.mapper.dto.UserInfoDtoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDtoTest {


    @Autowired
    UserInfoDtoMapper userInfoDtoMapper;

    @Test
    public void test1(){


        List<UserInfoDto> allUser = userInfoDtoMapper.findAllUser();

        allUser.stream().forEach(System.out::println);


    }

}
