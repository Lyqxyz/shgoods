package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShBook {

    private String bookId;
    private String bookName;
    private String bookIsbn;
    private String bookAuthor;
    private String bookPublish;
    private Double bookOriginalPrice;
    private Double bookSellingPrice;
    private Integer bookCount;
    private Integer bookNao;
    private String bookDes;
    private Integer bookState;
    private Date bookCreationTime;
    private Date bookUpdateTime;
    private String bookCid;
}
