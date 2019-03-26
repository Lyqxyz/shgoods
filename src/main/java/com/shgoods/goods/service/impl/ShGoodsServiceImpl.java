package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.service.ShGoodsService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShGoodsServiceImpl implements ShGoodsService {

    @Autowired
    ShGoodsMapper shGoodsMapper;


    @Override
    public List<ShGoods> all() {

        List<ShGoods> allGoods = shGoodsMapper.all();

        return  allGoods;
    }

    @Override
    public ResponseVo add(ShGoods shGoods) {

        ResponseVo responseVo = new ResponseVo();

        Integer integer = shGoodsMapper.add(shGoods);

        if(integer==1){
            responseVo.setCode("1");
            responseVo.setMessage("添加成功");

            responseVo.getInfo().put("goods",shGoods);
        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("添加失败");
            responseVo.getErrors().put("errors", Arrays.asList("非法添加"));
        }

        return responseVo;

    }
}
