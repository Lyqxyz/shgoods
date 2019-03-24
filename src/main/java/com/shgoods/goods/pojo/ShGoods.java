package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author lyq
 */
@Data
public class ShGoods {

    private String goodsId;
    private String goodsTitle;
    private Double goodsOriginalPrice;
    private Double goodsSellingPrice;
    private Integer goodsNao;
    private Integer goodsState;
    private Date goodsReleaseTime;
    private Date goodsUpdateTime;
    private String goodsDes;
    private Integer goodsCount;
    private ShCollege goodsCid;
    private String goodsCid1;
}
