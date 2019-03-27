package com.shgoods.goods.vo.index;

import lombok.Data;

/**
 *
 * @author lyq
 *
 * 前段首页数据
 */

@Data
public class GoodsListVo {

    private String name;

    private String Price;

    private  String image;

    private String xsImage;

    /**
     * 是否是书
     */
    private Integer okBook;


}
