package com.example.demo2.model;

public class ResultEntity<T> {
    //错误码 0代表成功，1代表失败
    private Integer code;

    //错误提示信息
    private String msg;

    //接口返回数据
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
