package com.geeker.love.utils;

import lombok.Data;

@Data
public class ResultInfo {
    private int code;
    private String msg;
    private Object obj;
    private Object obj2;

    public static ResultInfo success(Object obj) {
        ResultInfo res = new ResultInfo();
        res.setObj(obj);
        res.setCode(200);
        res.setMsg("successful");
        return res;
    }
    public static ResultInfo fail(Object obj) {
        ResultInfo res = new ResultInfo();
        res.setCode(500);
        res.setMsg((String) obj);
        return res;
    }
}
