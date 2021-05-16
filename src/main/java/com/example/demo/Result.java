package com.example.demo;

import java.util.HashMap;

public class Result {
    private HashMap<String,Object>Data;
    private String msg;
    private Integer status;

    public HashMap<String, Object> getData() {
        return Data;
    }

    public void setData(HashMap<String, Object> data) {
        Data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Result(HashMap<String, Object> data, String msg, Integer status) {
        Data = data;
        this.msg = msg;
        this.status = status;
    }
}
