package com.shgoods.goods.service.dto.impl;

import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.mapper.dto.UserInfoDtoMapper;
import com.shgoods.goods.service.dto.UserInfoDtoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 用户信息
 * @author lyq
 *
 */
public class UserInfoServiceImol implements UserInfoDtoService {

    @Autowired
    UserInfoDtoMapper userInfoDtoMapper;
    @Override
    public List<UserInfoDto> findAllUser() {
        //可以在这里对数据进行处理
        List<UserInfoDto> allUser = userInfoDtoMapper.findAllUser();

        return allUser;
    }
}
