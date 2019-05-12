package com.shgoods.goods;

import com.shgoods.goods.bean.Email;
import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.mapper.EmailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Email1Test {
    @Autowired
    EmailMapper emailMapper;

    @Test
    public void test2(){

        Email email = new Email();

        email.setEmailAddress("lu951384850@163.com");

        email.setEmailCode(EmailCode.random());

        email.setEmailType(EmailCode.EMAIL_TYPE_RER);

        email.setEmailCreated(LocalDateTime.now());

        email.setEmailUpdate(LocalDateTime.now());

        emailMapper.add(email);
    }

    @Test
    public void  test3(){

        Email email = new Email();

        email.setEmailAddress("lu951384850@163.com");

        email.setEmailType(EmailCode.EMAIL_TYPE_RER);

        Email select = emailMapper.select(email);

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime emailUpdate = select.getEmailUpdate();

        LocalDateTime localDateTime = emailUpdate.plusSeconds(50);

        boolean after = now.isAfter(localDateTime);

        System.out.println(after);

        System.out.println(select);

    }

    @Test
    public void test(){

        Email email = new Email();

        email.setEmailUpdate(LocalDateTime.now());

        email.setEmailType(EmailCode.EMAIL_TYPE_RER);

        email.setEmailAddress("lu951384850@163.com");

        email.setEmailCode(EmailCode.random());
        emailMapper.update(email);

    }
}
