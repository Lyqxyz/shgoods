package com.shgoods.goods.service.dto.impl;

import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.mapper.dto.UserInfoDtoMapper;
import com.shgoods.goods.service.dto.UserInfoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息
 * @author lyq
 *
 */
@Service
public class UserInfoDtoServiceImpl implements UserInfoDtoService {

    @Autowired
    UserInfoDtoMapper userInfoDtoMapper;
    @Override
    public List<UserInfoDto> findAllUser() {
        //可以根据权限做判断  过滤数据
        List<UserInfoDto> allUser = userInfoDtoMapper.findAllUser();

        return allUser;
    }
}
