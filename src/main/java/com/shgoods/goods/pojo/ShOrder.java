package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShOrder {

    private String orderId;
    private String orderNum;
    private ShUser orderUid;
    private Double orderPrice;
    private Integer orderIsPay;
    private Date orderReceiptTime;
    private Integer orderReceipt;
    private Integer orderState;
    private Date orderCreationTime;
    private Date orderUpdateTime;
    private Integer orderMode;
    private String orderAddress;


}
