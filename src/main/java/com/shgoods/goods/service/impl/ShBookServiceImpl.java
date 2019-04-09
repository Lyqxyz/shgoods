package com.shgoods.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.*;

/**
 * @author lyq
 */
@Service
public class ShBookServiceImpl implements ShBookService {

    @Autowired
    ShBookMapper shBookMapper;

    @Override
    public ResponseVo addBook(ShBook shBook) {

        List<String> errors = checkAttrs(shBook);

        ResponseVo responseVo = new ResponseVo();

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");

        }else{

            Integer integer = shBookMapper.addBook(shBook);

            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("添加成功");

                responseVo.getInfo().put("book",shBook);
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("添加失败");
                responseVo.getErrors().put("errors", Arrays.asList("非法添加"));
            }
        }


        return responseVo;
    }

    @Override
    public List<ShBook> all() {

        List<ShBook> allBook = shBookMapper.all();

        return  allBook;
    }

    @Override
    public ResponseVo selectByUser(ShUser shUser) {

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setMessage("请求成功");

        List<ShBook> shBooks = shBookMapper.selectByUser(shUser);

        responseVo.getInfo().put("data",shBooks);

        return responseVo;

    }

    @Override
    public ResponseVo delByBookId(ShBook shBook) {

        ResponseVo responseVo = new ResponseVo();

        if(shBook!=null&&shBook.getBookId()!=null){

            Integer del = shBookMapper.del(shBook);

            if(del==1){
                responseVo.setCode("1");
                responseVo.setMessage("删除成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("已是删除状态");
            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("删除失败");
        }
        responseVo.setDate(new Date());


        return responseVo;

    }

    @Override
    public ResponseVo selectByClass(ShClass shClass) {


        ResponseVo ok = ResponseUtil.isOk();

//        List<ShBook> shBooks = shBookMapper.selectByClass(shClass);
//
//        ok.getInfo().put("data",shBooks);

        return ok;
    }

    @Override
    public ResponseVo selectWithUser(ShBook shBook) {


        ResponseVo ok = ResponseUtil.isOk();

        ShBook shBook1 = shBookMapper.selectWithUser(shBook);


        ok.getInfo().put("data",shBook1);

        return ok;

    }


    public List<String> checkAttrs(ShBook shBook){

        List<String> errors = new ArrayList<>();

        ShBook shBook1 = shBookMapper.checkISBN(shBook);

        if(!Objects.isNull(shBook1)){

            errors.add("ISBN已经存在");

        }

        return errors;


    }
}
