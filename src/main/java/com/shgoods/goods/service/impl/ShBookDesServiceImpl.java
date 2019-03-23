package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookDesMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.service.ShBookDesService;
import com.shgoods.goods.util.FileUploadUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
public class ShBookDesServiceImpl implements ShBookDesService {

    @Autowired
    ShBookDesMapper shBookDesMapper;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Override
    public ResponseVo addPic( MultipartFile[] files,String bid) throws IOException {

        ResponseVo responseVo= new ResponseVo();

        List<List<String>> bookImages = fileUploadUtil.upload(files, "bookImage");

        for (List<String> bookImage :bookImages){

            ShBookDescription shBookDescription = new ShBookDescription();

            for(String image : bookImage){

                if(image.contains("5050")){
                    shBookDescription.setDesSmPath(image);
                }else if(image.contains("100200")){

                    shBookDescription.setDesMdPath(image);
                }else if(image.contains("300500")){

                    shBookDescription.setDesXsPath(image);
                }else{
                    shBookDescription.setDesInfo(image);
                }

            }

            ShBook shBook = new ShBook();

            shBook.setBookId(bid);

            shBookDescription.setGoodsId(shBook);

            shBookDescription.setDesState(1);

            Integer add = shBookDesMapper.add(shBookDescription);

        }

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setMessage("上传成功");

        responseVo.getInfo().put("imagesPath",bookImages);

        return responseVo;

    }

    @Override
    public ResponseVo search(ShBook shBook) {

        shBookDesMapper.search(shBook);




    }
}
