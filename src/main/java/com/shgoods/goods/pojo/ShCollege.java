package com.shgoods.goods.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShCollege implements Serializable {

    private String collegeId;
    private String collegeNum;
    private String collegeName;
    private String collegeDes;
}
