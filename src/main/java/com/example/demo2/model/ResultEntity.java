package com.example.demo2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultEntity<T> {
    //错误码 0代表成功，1代表失败
    private Integer code;

    //错误提示信息
    private String msg;

    //接口返回数据
    private T data;
}
