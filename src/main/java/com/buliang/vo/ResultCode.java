package com.buliang.vo;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(2000,"响应成功"),
    Fail(1004,"响应失败"),

    LOGIN_FAIL(5000,"登陆失败,用户名或密码错误"),

    REGISTER_FAIL(1002,"注册失败"),
    REGISTER_SUCCESS(2000,"注册成功"),

    ADD_CART_SUCCESS(2000,"添加成功"),
    ADD_CART_FAIL(1003,"商品数量不足"),

    LOGIC_DELETE_SUCCESS(2000,"删除成功"),
    LOGIC_DELETE_FAIL(1004,"删除失败"),

    REMOVE_CART_SUCCESS(2000,"删除成功"),
    REMOVE_CART_FAIL(1005,"删除失败");




    private int code;
    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
