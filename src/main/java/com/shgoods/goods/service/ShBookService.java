package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

/**
 * @author lyq
 */
public interface ShBookService {

     ResponseVo addBook(ShBook shBook);

     List<ShBook> all();
}
