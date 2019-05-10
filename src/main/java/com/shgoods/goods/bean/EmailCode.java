package com.shgoods.goods.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class EmailCode {

    private String email;

    private String code;

    private LocalDateTime localDateTime;

    /**
     *
     * @return true 过期了 false 没有过期
     */
    private  boolean isExpire(){

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = this.localDateTime.plusSeconds(10);

        return now.isAfter(localDateTime);
    }
    public static String random(){

        ThreadLocalRandom threadLocalRandom= ThreadLocalRandom.current();

        int random = threadLocalRandom.nextInt(100000);

        String s = String.valueOf(random);

        return s;
    }
}
