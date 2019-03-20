package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShBookDescription {

    private String desId;

    private ShGoods desGid;

    private String desinfo;

    private String desXsPath;
    private String desSmPath;
    private String desMdPath;

    private String desOriginalFilename;

    private Integer desState;

    private Date desCreationTime;

    private Date desUpdateTime;
}
