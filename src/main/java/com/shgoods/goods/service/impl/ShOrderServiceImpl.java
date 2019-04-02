package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShOrderMapper;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShOrderServiceImpl implements ShOrderService {


    @Autowired
    ShOrderMapper shOrderMapper;

    @Override
    public List<ShOrder> info() {

        List<ShOrder> shOrders = shOrderMapper.allOrder();

        return shOrders;


    }

    @Override
    public ResponseVo add(ShOrder shOrder) {


        Integer add = shOrderMapper.add(shOrder);

        if(add==1){

            ResponseVo ok = ResponseUtil.isOk();

            ok.getInfo().put("data",shOrder);

            return  ok;

        }else{

            ResponseVo error = ResponseUtil.isError();
            return  error;
        }

    }
}
