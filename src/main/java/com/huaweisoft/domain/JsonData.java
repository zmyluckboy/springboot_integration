package com.huaweisoft.domain;

import java.io.Serializable;

public class JsonData implements Serializable {
    private Integer code;
    private Object data;
    private String msg;

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }
    public static JsonData buildSuccess(Object data,String msg) {
        return new JsonData(0,data,msg);
    }
    public static JsonData buildSuccess(Object data,Integer code) {
        return new JsonData(code,data,null);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }
    public static JsonData buildError(String msg, Integer code) {
        return new JsonData(code, null, msg);
    }

}
