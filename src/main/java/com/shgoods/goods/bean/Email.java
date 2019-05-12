package com.shgoods.goods.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Email {

    private String emailId;

    private String emailAddress;

    private String emailCode;

    private String emailType;

    private LocalDateTime emailCreated;

    private LocalDateTime emailUpdate;

}
