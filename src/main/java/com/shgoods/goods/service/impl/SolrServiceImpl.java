package com.shgoods.goods.service.impl;

import com.shgoods.goods.service.SolrService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SolrServiceImpl implements SolrService {

    @Autowired
    SolrClient solrClient;


    @Override
    public ResponseVo all(String keyWords) {

        try {
            Object o = allBook(keyWords);
            Object o1 = allGoods(keyWords);

            ResponseVo ok = ResponseUtil.isOk();

            Map<String, Object> info = ok.getInfo();

            info.put("goods",o1);

            info.put("book",o);

            return ok;

        } catch (IOException e) {

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("检索失败");

            return error;

        } catch (SolrServerException e) {

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("检索失败");

            return error;
        }

    }

     private Object allBook(String keyWords) throws IOException, SolrServerException {

        SolrQuery solrQuery = new SolrQuery();

        solrQuery.setQuery(keyWords);

        solrQuery.setParam("df","allBook");

        solrQuery.setParam("fq","bookState:1");

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

                            boolean empty = value1.isEmpty();
                            if(!empty){
                                result.setField(key1,value1.get(0));
                            }

                        }
                    }

                }
            }

            result.addField("okBook",1);

        }

        return results;
    }

     private Object allGoods(String keyWords) throws IOException, SolrServerException {

        SolrQuery solrQuery = new SolrQuery();

        solrQuery.setQuery(keyWords);

        solrQuery.setParam("df","allGoods");

        solrQuery.setParam("fq","goodsState:1");

        solrQuery.setHighlight(true);

        solrQuery.setHighlightSimplePre("<span style='color:red'>");

        solrQuery.setHighlightSimplePost("</span>");

        solrQuery.addHighlightField("goodsTitle");

        solrQuery.addHighlightField("goodsDes");

        QueryResponse bookCollection = solrClient.query("goodsCollection", solrQuery);

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

                            boolean empty = value1.isEmpty();
                            if(!empty){
                                result.setField(key1,value1.get(0));
                            }
                        }
                    }

                }
            }

            result.addField("okBook",0);

        }

        return results;
    }


}
