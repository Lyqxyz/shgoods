package com.shgoods.goods.mapper;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShClass;
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

     Integer del(ShBook shBook);

     List<ShBookDescription> selectByClass(ShClass shClass);

     ShBook selectById(ShBook shBook);

     ShBook selectWithUser(ShBook shBook);

     Integer updateState(ShBook shBook);

     ShBook selectWithAllVar(String id);

     Integer updateBook(ShBook shBook);




}
