package com.so.studyonline.enhance;

import com.alibaba.fastjson.JSONObject;
import com.so.studyonline.config.ErrorCode;

import java.util.HashMap;
import java.util.Map;

public class ResMessage {
    /* 系统操作失败 */
    public String sysError() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SYS_ERROR.getCode());
        msg.put("errMsg", ErrorCode.SYS_ERROR.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public String sysError(String errCode) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", ErrorCode.SYS_ERROR.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public String sysError(String errCode, String errMsg) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", errMsg);
        return JSONObject.toJSONString(msg);
    }

    /* 交易操作失败 */
    public static String error() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.ERROR.getCode());
        msg.put("errMsg", ErrorCode.ERROR.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public static String error(String errCode) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", ErrorCode.ERROR.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public static String error(String errCode, String errMsg) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", errMsg);
        return JSONObject.toJSONString(msg);
    }

    /* 默认系统操作成功code、message */
    public String sysSuccess() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SYS_SUCCESS.getCode());
        msg.put("errMsg", ErrorCode.SYS_SUCCESS.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public String sysSuccess(Object object) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SYS_SUCCESS.getCode());
        msg.put("errMsg", ErrorCode.SYS_SUCCESS.getMessage());
        msg.put("data", object);
        return JSONObject.toJSONString(msg);
    }

    /* 交易操作成功 */
    public static String success() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SUCCESS.getCode());
        msg.put("errMsg", ErrorCode.SUCCESS.getMessage());
        return JSONObject.toJSONString(msg);
    }

    public static String success(String errCode, String errMsg) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", errCode);
        msg.put("errMsg", errMsg);
        return JSONObject.toJSONString(msg);
    }

    public static String success(Object object) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SUCCESS.getCode());
        msg.put("errMsg", ErrorCode.SUCCESS.getMessage());
        msg.put("data", object);
        return JSONObject.toJSONString(msg);
    }

    public static String success(String str) {
        Map<String, String> msg = new HashMap<>();
        msg.put("errCode", ErrorCode.SUCCESS.getCode());
        msg.put("errMsg", ErrorCode.SUCCESS.getMessage());
        msg.put("data", str);
        return JSONObject.toJSONString(msg);
    }
}
