package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookDesMapper;
import com.shgoods.goods.mapper.ShGoodsDesMapper;
import com.shgoods.goods.service.IndexGoodsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexGoodsListServiceImpl implements IndexGoodsListService {

    @Autowired
    ShBookDesMapper shBookDesMapper;

    @Autowired
    ShGoodsDesMapper shGoodsDesMapper;





}
