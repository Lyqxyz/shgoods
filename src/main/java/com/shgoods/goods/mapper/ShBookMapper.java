package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lyq
 *
 */
@Mapper
public interface ShBookMapper {

     Integer addBook(ShBook shBook);


     ShBook checkISBN(ShBook shBook);

    ShBook hasBook(ShBook shBook);


}
