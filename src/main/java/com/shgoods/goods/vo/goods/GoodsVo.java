package com.shgoods.goods.vo.goods;


import com.shgoods.goods.pojo.ShCollege;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class GoodsVo {

    private String goodsId;

    @NotNull(message = "标题解析异常")
    @NotBlank(message = "标题不能为空")
    private String goodsTitle;


    @Min(value = 1,message = "不能为负数")
    private Double goodsOriginalPrice;


    @Min(value = 1,message = "不能为负数")
    private Double goodsSellingPrice;


    @Max(value = 10,message = "不能超过10")
    @Min(value = 1,message = "不能小于1")
    private Integer goodsNao;

    private String goodsDes;


    @Min(value = 1,message = "不能为负数")
    private Integer goodsCount;

    private String goodsCid1;

    private String uid;

}
