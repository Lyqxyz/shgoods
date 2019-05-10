package com.shgoods.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.shgoods.goods.bean.ShBookSolr;
import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.io.IOException;
import java.util.*;

/**
 * @author lyq
 */
@Service
public class ShBookServiceImpl implements ShBookService {

    @Autowired
    ShBookMapper shBookMapper;

    @Autowired
    SolrClient solrClient;

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

            ShBookSolr shBookSolr = new ShBookSolr();

            BeanUtils.copyProperties(shBook,shBookSolr);

            try {
                solrClient.addBean("bookCollection",shBookSolr,2000);
            } catch (IOException e) {

                e.printStackTrace();

            } catch (SolrServerException e) {
                e.printStackTrace();
            }
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

    @Override
    public ResponseVo selectWithAllVar(String id) {

        ShBook shBook = shBookMapper.selectWithAllVar(id);

        ResponseVo ok = ResponseUtil.isOk();

        ok.getInfo().put("data",shBook);

        return ok;

    }

    @Override
    public ResponseVo updateBook(ShBook shBook) {


        Integer integer = shBookMapper.updateBook(shBook);


        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("更新成功");

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
