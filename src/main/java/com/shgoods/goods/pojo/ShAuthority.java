package com.shgoods.goods.pojo;


import lombok.Data;

import java.util.Date;

/**
 * @author lyq
 */
@Data
public class ShAuthority {

    private String authorityId;
    private String  authorityNum;
    private String authorityName;
    private String authorityDes;
    private Date authorityCreationTime;
    private Date authorityUpdateTime;
    private Integer authorityState;
}
