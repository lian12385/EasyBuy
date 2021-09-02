package com.buliang.vo;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200,"响应成功"),
    LOGIN_FAIL(500,"登陆失败,用户名或密码错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
