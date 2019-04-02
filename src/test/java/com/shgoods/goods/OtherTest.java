package com.shgoods.goods;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OtherTest {


    @Test
    public void test1(){

       String uid= "1231245645460";

        String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHH"));
        System.out.println(s);




    }
}
