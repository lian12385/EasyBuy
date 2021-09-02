package com.buliang.vo;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(2000,"响应成功"),
    LOGIN_FAIL(5000,"登陆失败,用户名或密码错误"),
    REGISTER_FAIL(1002,"注册失败"),
    REGISTER_SUCCESS(2000,"注册成功");

    private int code;
    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
