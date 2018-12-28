package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShShopCar {


    private String shopCarId;
    private String shopCarUid;
    private String shopCarGid;
    private Integer shopCarCount;
    private Integer shopCarState;
    private Date shopCarCreationTime;
    private Date shopCarUpdateTime;
}
