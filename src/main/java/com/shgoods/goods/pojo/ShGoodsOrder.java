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

    private String gid;

    private ShGoods goGid;

    private ShBook goBid;

    private Integer goCount;

    private Integer goState;

    private Date goCreationTime;

    private Date goUpdateTime;

    private String goIdAll;

    private String goRes;

    /**
     * isBook 封装goBId;
     */
    private Integer goIsBook;


}
