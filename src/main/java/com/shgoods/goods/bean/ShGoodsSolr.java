package com.shgoods.goods.bean;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "goodsCollection")
public class ShGoodsSolr {

    @Field
    private String goodsId;

    @Field
    private String goodsTitle;

    @Field
    private String goodsDes;

    @Field
    private Integer goodsState;
}
