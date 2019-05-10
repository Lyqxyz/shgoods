package com.shgoods.goods;


import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class CacheTest {


    @Test
    public void test1(){

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.plusMinutes(5);

        LocalDateTime now1 = localDateTime.now();

        boolean after = now1.isAfter(localDateTime);

        System.out.println(after);

        System.out.println(now);

        System.out.println(localDateTime);

    }

    @Test
    public void Test(){

        ThreadLocalRandom threadLocalRandom= ThreadLocalRandom.current();


        for (int i =0;i<10;i++){
            int j = threadLocalRandom.nextInt(100000);
            System.out.println(j);
        }


    }
}
