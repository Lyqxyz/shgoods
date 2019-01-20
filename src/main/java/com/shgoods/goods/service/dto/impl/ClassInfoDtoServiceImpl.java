package com.shgoods.goods.service.dto.impl;

import com.shgoods.goods.dto.ClassInfoDto;
import com.shgoods.goods.mapper.dto.ClassInfoDtoMapper;
import com.shgoods.goods.service.dto.ClassInfoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoDtoServiceImpl implements ClassInfoDtoService {

    @Autowired
    ClassInfoDtoMapper classInfoDtoMapper;
    @Override
    public List<ClassInfoDto> findAll() {

        List<ClassInfoDto> all = classInfoDtoMapper.findAll();

        return  all;

    }
}
