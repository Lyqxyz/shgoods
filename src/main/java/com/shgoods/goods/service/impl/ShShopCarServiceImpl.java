package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.mapper.ShShopCarMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShShopCarService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ShShopCarServiceImpl implements ShShopCarService {

    @Autowired
    ShShopCarMapper shShopCarMapper;

    @Autowired
    ShBookMapper shBookMapper;

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @Override
    public List<ShShopCar> all() {

        List<ShShopCar> shShopCars = shShopCarMapper.allShopCar();


        return shShopCars;

    }

    @Override
    public ResponseVo del(ShShopCar shShopCar) {

        ResponseVo responseVo = new ResponseVo();

        if(shShopCar!=null&&shShopCar.getShopCarId()!=null){

            Integer integer = shShopCarMapper.delShopCar(shShopCar);
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

    @Override
    public ResponseVo selectByUser(ShUser shUser) {

        List<ShShopCar> shShopCars = shShopCarMapper.selectByUser(shUser);

        for (ShShopCar ss : shShopCars){

            if(!Objects.isNull(ss.getShopCarOkBook())){

                if(ss.getShopCarOkBook()==1){

                    ShBook shBook = new ShBook();

                    shBook.setBookId(ss.getShopCarGid());

                    ShBook shBook1 = shBookMapper.selectById(shBook);

                    ss.setShBook(shBook1);

                }else{

                    ShGoods shGoods = new ShGoods();

                    shGoods.setGoodsId(ss.getShopCarGid());

                    ShGoods shGoods1 = shGoodsMapper.selectById(shGoods);

                    ss.setShGoods(shGoods1);

                }
            }
        }

        ResponseVo ok = ResponseUtil.isOk();

        ok.getInfo().put("data",shShopCars);

        return ok;
    }

    @Override
    public ResponseVo addShopCar(ShShopCar shShopCar) {


        if(Objects.isNull(shShopCar)||
                Objects.isNull(shShopCar.getShopCarGid())||
                Objects.isNull(shShopCar.getShopCarUid()) ){
            return ResponseUtil.isError();
        }

        ResponseVo ok = ResponseUtil.isOk();

        ShShopCar has = shShopCarMapper.has(shShopCar);

        if(Objects.isNull(has)){

            int i = shShopCarMapper.countByUser(shShopCar.getShopCarUid());

            if(i>=10){
                ResponseVo error = ResponseUtil.isError();

                error.setMessage("购物车满了");

                return error;
            }

            Integer add = shShopCarMapper.add(shShopCar);

        }else{

            Integer integer = shShopCarMapper.updateShopCar(has);
        }

        return ok;

    }

    @Override
    public ResponseVo updataCount(ShShopCar shShopCar) {


        shShopCarMapper.updataCount(shShopCar);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("添加成功");

        return ok;
    }
}
