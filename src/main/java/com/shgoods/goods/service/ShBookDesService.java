package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShBookDesService {

    ResponseVo addPic(MultipartFile[] files,String bid) throws IOException;


    ResponseVo search(ShBook shBook);


}
