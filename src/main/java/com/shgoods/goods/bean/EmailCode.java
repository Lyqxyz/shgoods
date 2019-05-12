package com.shgoods.goods.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class EmailCode {

    /**
     * 过期时间120s
     */
    public static final long EXPIRE_SECOND=120;

    public static final String EMAIL_TYPE_RER="reg";

    public static final String EMAIL_TYPE_CHANGE_PWD="changePwd";

    public static String random(){

        Random random = new Random();

        int i = random.nextInt(100000);

        String s = String.valueOf(i);

        return s;
    }
}
