package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShGoodsDescription {

    private String desId;

    private ShGoods goodsId;

    private String desInfo;

    private String desXsPath;

    private String desSmPath;

    private String desMdPath;

    private Integer desState;

    private Date desCreationTime;

    private Date desUpdateTime;
}
