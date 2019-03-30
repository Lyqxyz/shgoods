package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyq
 *
 */
@Mapper
public interface ShBookMapper {

     Integer addBook(ShBook shBook);

     List<ShBook> all();

     ShBook checkISBN(ShBook shBook);

     ShBook hasBook(ShBook shBook);

     List<ShBook> selectByUser(ShUser shUser);

}
