package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lyq
 */
@Data
public class ShRole {

    private String roleId;
    private String roleNum;
    private String roleName;
    private String roleDes;
    private Date roleCreationTime;
    private Date roleUpdateTime;
    private Integer roleState;

    private List<ShUser> shUsers;
}
