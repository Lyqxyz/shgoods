package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShRoleMapper;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShRoleServiceImpl implements ShRoleService {

    @Autowired
    ShRoleMapper shRoleMapper;

    @Override
    public List<ShRole> findAll() {
        List<ShRole> allRole = shRoleMapper.findAllRole();
        return allRole;
    }
}
