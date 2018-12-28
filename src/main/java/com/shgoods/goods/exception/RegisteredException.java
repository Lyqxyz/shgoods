package com.shgoods.goods.exception;

/**
 * @author lyq
 * 注册异常
 */
public class RegisteredException extends RuntimeException {

    public RegisteredException(){
        super("注册失败");
    }
}
