package com.shgoods.goods;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {


    @Test
    public void test(){

        Md5Hash md5Hash = new Md5Hash("123456", ByteSource.Util.bytes("12001"),20);

        String s = md5Hash.toString();

        System.out.println(s);

    }
}
