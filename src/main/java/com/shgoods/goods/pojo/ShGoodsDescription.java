package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShGoodsDescription {

    private String desId;

    private ShGoods desGid;

    private String desType;

    private Integer desInfo;

    private Integer desState;

    private Date desCreationTime;

    private Date desUpdateTime;
}
