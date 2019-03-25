package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShGoodsDesMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.ShGoodsDesService;
import com.shgoods.goods.util.FileUploadUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ShGoodsDesServiceImpl implements ShGoodsDesService {

    @Autowired
    ShGoodsDesMapper shGoodsDesMapper;

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Override
    public ResponseVo search(ShGoods shGoods) {

        ShGoods goods = shGoodsMapper.has(shGoods);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        if(goods==null){

            responseVo.setCode("-1");

            responseVo.setMessage("书籍不存在");

        }else{
            if(Objects.isNull(shGoods)||Objects.isNull(shGoods.getGoodsId())){

                responseVo.setCode("-1");

                responseVo.setMessage("id不能为空");

            }else {

                List<ShGoodsDescription> search = shGoodsDesMapper.search(shGoods);

                responseVo.setCode("1");

                responseVo.setMessage("请求成功");

                responseVo.getInfo().put("BookDesInfo",search);
            }


        }

        return responseVo;
    }

    @Override
    public ResponseVo addPicToGoods(MultipartFile[] files, String gid) throws IOException {

        ResponseVo responseVo= new ResponseVo();

        List<List<String>> bookImages = fileUploadUtil.upload(files, "goodsImage");

        for (List<String> bookImage :bookImages){


            ShGoodsDescription shGoodsDescription = new ShGoodsDescription();

            for(String image : bookImage){

                if(image.contains("5050")){
                    shGoodsDescription.setDesSmPath(image);
                }else if(image.contains("100200")){

                    shGoodsDescription.setDesMdPath(image);
                }else if(image.contains("300500")){

                    shGoodsDescription.setDesXsPath(image);
                }else{
                    shGoodsDescription.setDesInfo(image);
                }

            }

            ShGoods shGoods = new ShGoods();

            shGoods.setGoodsId(gid);

            shGoodsDescription.setGoodsId(shGoods);

            shGoodsDescription.setDesState(1);

            shGoodsDesMapper.add(shGoodsDescription);
        }

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setMessage("上传成功");

        responseVo.getInfo().put("imagesPath",bookImages);

        return responseVo;



    }

    @Override
    public ResponseVo del(ShGoodsDescription shGoodsDescription) {


        ResponseVo responseVo = new ResponseVo();
        if(shGoodsDescription!=null&&shGoodsDescription.getDesId()!=null){

            Integer del = shGoodsDesMapper.del(shGoodsDescription);

            if(del==1){
                responseVo.setCode("1");
                responseVo.setMessage("删除成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是删除状态");
            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("禁用失败");
        }
        responseVo.setDate(new Date());

        return responseVo;





    }
}
