package com.yzf.demo.util;

/**
 * ApiReturnObject
 *
 * @author Administrator
 * @date 2019/12/10
 */
public class ApiReturnObject {
    private Integer code;
    private String msg;
    private Object data;

    public ApiReturnObject(){}
    public ApiReturnObject(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
