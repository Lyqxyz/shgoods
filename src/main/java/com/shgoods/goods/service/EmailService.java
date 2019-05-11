package com.shgoods.goods.service;

import com.shgoods.goods.bean.EmailCode;
import com.shgoods.goods.vo.ResponseVo;

public interface EmailService {

     void sendEmail(String to,String subject,String content);

     EmailCode generate(String email);

     EmailCode get(String email);

     ResponseVo checkEmail(String email);
}
