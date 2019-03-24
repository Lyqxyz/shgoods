package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShGoodsDesService {


    ResponseVo search(ShGoods shGoods);


    ResponseVo addPicToGoods(MultipartFile[] files, String gid) throws IOException;
}
