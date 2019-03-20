package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author lyq
 */
@Data
public class ShGoodsOrder {

    private String goId;

    private ShOrder goOid;

    private ShGoods goGid;

    private ShBook goBid;

    private Integer goCount;

    private Integer goState;

    private Date goCreationTime;

    private Date goUpdateTime;

    private String goIdAll;

    /**
     * isBook 封装goBId;
     */
    private Integer goIsBook;


}
