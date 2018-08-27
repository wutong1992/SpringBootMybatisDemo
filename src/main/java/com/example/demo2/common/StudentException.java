package com.example.demo2.common;

public class StudentException extends RuntimeException {
    private Integer code;

    public StudentException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
