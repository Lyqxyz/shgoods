package com.shgoods.goods;


import com.shgoods.goods.bean.ShBookSolr;
import com.shgoods.goods.bean.ShGoodsSolr;
import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.service.SolrService;
import com.shgoods.goods.vo.ResponseVo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.SocketOption;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrTest {


    @Autowired
    SolrClient solrClient;

    @Autowired
    ShBookMapper shBookMapper;

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @Autowired
    SolrService solrService;

    @Test
    public void test() throws IOException, SolrServerException {


        List<ShBook> all = shBookMapper.all();

        for (ShBook shBook : all) {


            ShBookSolr shBookSolr = new ShBookSolr();

            BeanUtils.copyProperties(shBook,shBookSolr);

            solrClient.addBean("bookCollection",shBookSolr,1000);
            System.out.println(shBookSolr);
        }
    }
    @Test
    public void test2() throws IOException, SolrServerException {

        SolrQuery solrQuery = new SolrQuery();

        solrQuery.setQuery("重庆");

        solrQuery.setParam("df","allBook");

        solrQuery.setHighlight(true);

        solrQuery.setHighlightSimplePre("<span style='color:red'>");

        solrQuery.setHighlightSimplePost("</span>");

        solrQuery.addHighlightField("bookName");

        solrQuery.addHighlightField("bookAuthor");

        solrQuery.addHighlightField("bookPublish");

        solrQuery.addHighlightField("bookDes");

        QueryResponse bookCollection = solrClient.query("bookCollection", solrQuery);

        Map<String, Map<String, List<String>>> highlighting = bookCollection.getHighlighting();

        SolrDocumentList results = bookCollection.getResults();

        Set<Map.Entry<String, Map<String, List<String>>>> entries = highlighting.entrySet();

        for (SolrDocument result : results) {

            for (Map.Entry<String, Map<String, List<String>>> entry : entries) {

                String key = entry.getKey();

                Map<String, List<String>> value = entry.getValue();

                Set<Map.Entry<String, List<String>>> entries1 = value.entrySet();

                if(result.containsValue(key)){

                    for (Map.Entry<String, List<String>> stringListEntry : entries1) {

                        String key1 = stringListEntry.getKey();

                        List<String> value1 = stringListEntry.getValue();

                        if(result.containsKey(key1)){

                            result.setField(key1,value1);
                        }
                    }

                }
            }

        }

    }

    @Test
    public void test3() throws IOException, SolrServerException {

        SolrInputDocument solrInputFields = new SolrInputDocument();

        solrInputFields.addField("bookId","98151011553640456");

        solrInputFields.addField("bookIsbn", UUID.randomUUID().toString());

        solrClient.add("bookCollection",solrInputFields,1000);

    }

    @Test
    public void test4() throws IOException, SolrServerException {


        solrClient.deleteByQuery("bookCollection","bookId:98187268694474754",2000);
    }
    @Test
    public void test5() throws IOException, SolrServerException {

        List<ShGoods> all = shGoodsMapper.all();

        for (ShGoods shGoods : all) {

            ShGoodsSolr shGoodsSolr = new ShGoodsSolr();

            BeanUtils.copyProperties(shGoods,shGoodsSolr);

            solrClient.addBean("goodsCollection",shGoodsSolr,1000);



        }

    }


    @Test
    public void test6(){

        ResponseVo info = solrService.all("峰惠");

        System.out.println(info);

    }
}
