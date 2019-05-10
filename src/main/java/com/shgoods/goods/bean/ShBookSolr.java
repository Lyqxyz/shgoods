package com.shgoods.goods.bean;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "bookCollection")
public class ShBookSolr {

    @Field
    private String bookId;

    @Field
    private String bookName;

    @Field
    private String bookIsbn;

    @Field
    private String bookAuthor;

    @Field
    private String bookPublish;

    @Field
    private String bookDes;

    @Field
    private Integer bookState;

}
