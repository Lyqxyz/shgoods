package com.shgoods.goods.service;

import com.shgoods.goods.bean.Email;
import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.vo.ResponseVo;

public interface EmailService {

     void sendEmail(String to,String subject,String content);
//
//     EmailCode generate(String email);
//
     Email get(Email email);

     ResponseVo checkEmail(String email);

     ResponseVo checkEmailForget(String email);

     ResponseVo forgetPwd(String mail,String code,String pwd);
}
