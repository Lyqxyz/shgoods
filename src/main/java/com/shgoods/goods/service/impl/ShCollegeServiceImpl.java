package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShCollegeMapper;
import com.shgoods.goods.pojo.ShCollege;
import com.shgoods.goods.service.ShCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShCollegeServiceImpl implements ShCollegeService {

    @Autowired
    ShCollegeMapper shCollegeMapper;

    @Override
    public List<ShCollege> allCollege() {


        List<ShCollege> usefulCollege = shCollegeMapper.findUsefulCollege();

        return usefulCollege;

    }
}
