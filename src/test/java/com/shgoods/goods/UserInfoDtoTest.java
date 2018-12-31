package com.shgoods.goods;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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



        PageHelper.startPage(1, 1);

        List<UserInfoDto> allUser = userInfoDtoMapper.findAllUser();

        PageInfo page = new PageInfo(allUser,5);

        String s = JSON.toJSONString(page);

        System.out.println(s);

    }

}
