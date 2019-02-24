package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyq
 */
@Service
public class ShBookServiceImpl implements ShBookService {

    @Autowired
    ShBookMapper shBookMapper;

    @Override
    public ResponseVo addBook(ShBook shBook) {

        Integer integer = shBookMapper.addBook(shBook);



        return null;
    }
}
