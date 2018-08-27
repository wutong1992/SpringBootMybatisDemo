package com.example.demo2.common;

import com.example.demo2.model.ResultEntity;

public class ResultUtil {

    public static ResultEntity success (Object obj) {
        ResultEntity result = new ResultEntity();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static ResultEntity success () {
        ResultEntity result = new ResultEntity();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static ResultEntity error (Integer code, String msg) {
        ResultEntity result = new ResultEntity();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
