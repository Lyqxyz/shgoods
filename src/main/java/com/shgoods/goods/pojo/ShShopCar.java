package com.shgoods.goods.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lyq
 * 购物车
 */
@Data
public class ShShopCar  {

    private String shopCarId;

    private String shopCarUid;

    private String shopCarGid;

    private Integer shopCarCount;

    private Integer shopCarState;

    private Date shopCarCreationTime;

    private Date shopCarUpdateTime;

    private Integer shopCarOkBook;

    private ShGoods shGoods;

    private ShBook shBook;

    private ShUser shUser;


}
