package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.vo.ResponseVo;

/**
 * @author lyq
 */
public interface ShBookService {

    public ResponseVo addBook(ShBook shBook);
}
