package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShGoodsService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
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

    @Override
    public ResponseVo selectByUser(ShUser shUser) {

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setMessage("请求成功");

        List<ShGoods> shGoods = shGoodsMapper.selectByUser(shUser);

        responseVo.getInfo().put("data",shGoods);

        return responseVo;
    }

    @Override
    public ResponseVo selectByClass(ShClass shClass) {

        ResponseVo ok = ResponseUtil.isOk();
//
//        List<ShGoods> shGoods = shGoodsMapper.selectByClass(shClass);
//
//        ok.getInfo().put("data",shGoods);

        return ok;

    }

    @Override
    public ResponseVo selectWithUser(ShGoods shGoods) {


        ResponseVo ok = ResponseUtil.isOk();


        ShGoods shGoods1 = shGoodsMapper.selectWithUser(shGoods);


        ok.getInfo().put("data",shGoods1);

        return ok;
    }
}
