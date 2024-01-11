package com.yola.common.exception;

import org.springframework.validation.BindingResult;

import javax.xml.soap.SAAJResult;

/*
    写一个枚举类，规定各种出错的状态码
 */
public enum BizCodeEnume {
    UNKNOWN_EXCEPTION(10000,"未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验失败");
    private int code;
    private String msg;
    BizCodeEnume(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
