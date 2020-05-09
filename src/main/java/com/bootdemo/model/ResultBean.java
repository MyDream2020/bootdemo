package com.bootdemo.model;

/**
 * @Author: ASUS
 * @Date: 2020/5/5 8:24
 * @Version: 1.0
 */
public class ResultBean {
    private int code;
    private String body;

    public ResultBean(int code) {
        this.code = code;
    }

    public ResultBean(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
