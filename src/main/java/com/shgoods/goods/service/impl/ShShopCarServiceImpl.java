package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShShopCarMapper;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.service.ShShopCarService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShShopCarServiceImpl implements ShShopCarService {

    @Autowired
    ShShopCarMapper shShopCarMapper;

    @Override
    public List<ShShopCar> all() {

        List<ShShopCar> shShopCars = shShopCarMapper.allShopCar();


        return shShopCars;

    }

    @Override
    public ResponseVo del(ShShopCar shShopCar) {

        ResponseVo responseVo = new ResponseVo();
        if(shShopCar!=null&&shShopCar.getShopCarId()!=null){

            Integer integer = shShopCarMapper.del(shShopCar);
            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("删除成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是删除状态");
                responseVo.getErrors().put("errors", Arrays.asList("用户已经是删除状态"));
            }
        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("删除失败");
            responseVo.getErrors().put("errors", Arrays.asList("用户id为空"));
        }
        responseVo.setDate(new Date());
        return responseVo;
    }
}
