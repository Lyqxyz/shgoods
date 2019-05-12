package com.shgoods.goods.service.impl;

import com.shgoods.goods.bean.Email;
import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.mapper.EmailMapper;
import com.shgoods.goods.mapper.ShUserMapper;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.EmailService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String mailFrom;

    @Autowired
    ShUserMapper shUserMapper;

    @Autowired
    EmailMapper emailMapper;


    @Async
    @Override
    public void sendEmail(String to, String subject, String text) {

        log.info("发送邮件："+text+"========================"+to);

        Email email = new Email();

        email.setEmailAddress(to);

        email.setEmailCode(EmailCode.random());

        email.setEmailType(text);

        email.setEmailCreated(LocalDateTime.now());

        email.setEmailUpdate(LocalDateTime.now());

        Email select = emailMapper.select(email);

        if(Objects.isNull(select)){

            emailMapper.add(email);

        }else{

            emailMapper.update(email);
        }

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(subject);

        message.setText(email.getEmailCode());

        message.setTo(to);

        message.setFrom(mailFrom);

        mailSender.send(message);
    }

    @Override
    public Email get(Email email) {
        Email select = emailMapper.select(email);
        return select;
    }
    @Override
    public ResponseVo checkEmail(String email) {

        ShUser shUser = new ShUser();

        shUser.setUserEmail(email);

        ShUser shUser1 = shUserMapper.checkShUserEmail(shUser);

        if(Objects.isNull(shUser1)){

            ResponseVo ok = ResponseUtil.isOk();

            ok.setMessage("已发送至邮箱");

            this.sendEmail(email,"注册码",EmailCode.EMAIL_TYPE_RER);

            return ok;

        }else {

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("邮箱已被注册");

            return error;
        }
    }

    @Override
    public ResponseVo checkEmailForget(String email) {

        ShUser shUser = new ShUser();

        shUser.setUserEmail(email);

        ShUser shUser1 = shUserMapper.checkShUserEmail(shUser);

        if(Objects.isNull(shUser1)){

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("邮箱还没有注册，请先注册！");

            return error;

        }else {

            ResponseVo ok = ResponseUtil.isOk();

            ok.setMessage("已发送至邮箱");

            this.sendEmail(email,"注册码",EmailCode.EMAIL_TYPE_CHANGE_PWD);

            return ok;

        }


    }

    @Override
    public ResponseVo forgetPwd(String mail, String code,String pwd) {

        Email email = new Email();

        email.setEmailType(EmailCode.EMAIL_TYPE_CHANGE_PWD);

        email.setEmailAddress(mail.trim());

        email.setEmailCode(code);

        Email select = emailMapper.select(email);

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime emailUpdate = select.getEmailUpdate();

        LocalDateTime localDateTime = emailUpdate.plusSeconds(EmailCode.EXPIRE_SECOND);

        boolean after = now.isAfter(localDateTime);

        if(after){
            ResponseVo error = ResponseUtil.isError();

            error.setMessage("验证码已失效");

            return error;
        }

        if(!select.getEmailCode().trim().equalsIgnoreCase(code.trim())){

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("验证码不正确");

            return error;
        }

        ShUser shUser = new ShUser();

        shUser.setUserEmail(mail.trim());

        ShUser shUser1 = shUserMapper.selectByEmail(mail.trim());

        Md5Hash md5Hash = new Md5Hash(pwd.trim(), ByteSource.Util.bytes(shUser1.getUserNum()),20);

        shUser.setUserPwd(md5Hash.toString());

        shUserMapper.updatePwd(shUser);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("修改成功");

        return ok;
    }


}
