package com.yzf.demo.util;

import com.alibaba.fastjson.JSON;

/**
 * ApiReturnUtil
 *
 * @author Administrator
 * @date 2019/12/10
 */
public class ApiReturnUtil {
    public static String error(String data){
        ApiReturnObject apiReturnObject = new ApiReturnObject();
        apiReturnObject.setCode(-1);
        apiReturnObject.setMsg("返回错误");
        apiReturnObject.setData(data);
        return JSON.toJSONString(apiReturnObject);
    }

    public static String success(String data){
        ApiReturnObject apiReturnObject = new ApiReturnObject();
        apiReturnObject.setCode(1);
        apiReturnObject.setMsg("返回成功");
        apiReturnObject.setData(data);
        return JSON.toJSONString(apiReturnObject);
    }
}
