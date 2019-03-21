package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShBookDescription {

    private String desId;

    private ShBook goodsId;

    private String desInfo;

    private String desXsPath;

    private String desSmPath;
    
    private String desMdPath;

    private Integer desState;

    private Date desCreationTime;

    private Date desUpdateTime;
}
