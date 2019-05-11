package com.shgoods.goods.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class EmailCode {

    private String email;

    private String code;

    private LocalDateTime localDateTime;

    /**
     * 过期时间120s
     */
    private static final long EXPIRE_SECOND=10;

    /**
     *
     * @return true 过期了 false 没有过期
     */
    public  boolean isExpire(){

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = this.localDateTime.plusSeconds(EXPIRE_SECOND);

        return now.isAfter(localDateTime);
    }
    public static String random(){

        Random random = new Random();

        int i = random.nextInt(100000);

        String s = String.valueOf(i);

        return s;
    }
}
