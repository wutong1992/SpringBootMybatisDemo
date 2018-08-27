package com.example.demo2.model;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    SIX_ERROR(106,"没有要查找的6号用户"),
    SEVEN_ERROR(107,"没有要查找的7号用户"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
