package com.shgoods.goods;


import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.service.ShAuthorityService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShAuthorityTest {

    @Autowired
    ShAuthorityService shAuthorityService;

    @Test
    public void test(){

        ShAuthority shAuthority = new ShAuthority();

        shAuthority.setAuthorityNum("1231345");

        shAuthority.setAuthorityName("权限1");

        shAuthority.setAuthorityState(1);

        ResponseVo add = shAuthorityService.add(shAuthority);

        System.out.println(add);


    }

}
