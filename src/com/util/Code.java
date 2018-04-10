package com.util;

/**
 * @Description:
 * @Author: Shihy
 * @Date: 2018/4/9 17:01
 */
public class Code {

    private String code;
    private String message;
    private Object body;

    public Code() {
    }

    public Code(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Code(String code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public Code(Object body) {
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Code buildSuccess(String message) {
        this.setCode("0");
        this.setMessage(message);
        return this;
    }

    public Code buildSuccess() {
        this.setCode("0");
        this.setMessage("success");
        return this;
    }

    public Code buildError(String message) {
        this.setCode("1");
        this.setMessage(message);
        return this;
    }

    public Code buildError() {
        this.setCode("1");
        this.setMessage("error");
        return this;
    }
}
