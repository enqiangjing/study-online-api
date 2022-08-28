package com.so.studyonline.config;


public enum ErrorCode {
    /* start */
    SUCCESS("2000", "交易成功！"),
    SYS_SUCCESS("success", "交易成功！"),
    ERROR("4000", "交易失败！"),
    SYS_ERROR("error", "系统错误！"),

    // 用户操作
    USER_LOGIN_ERROR("4001", "用户名或密码输入错误！"),
    USER_EXIST_ERROR("001005", "用户解析失败，请重新登录"),
    USER_INFO_NULL("4002", "用户名或密码为空！"),
    USER_VERIFY_CODE_NULL("4003", "验证码为空！"),
    USER_UPDATE_ERROR("4004", "用户信息更新失败！"),
    USER_PASS_UP_ERROR("4005", "用户新旧密码不一致！"),

    UP_IMG_ERROR("4005", "图片上传失败！"),

    UP_IMG_REMOTE_ERROR("4005", "图片上传远程服务器失败！"),

    ARTICLE_EDIT_ERROR("4031", "文章编辑失败！"),

    ADD_FLOOR_ERROR("4041", "盖楼失败！"),
    ADD_COMMENT_ERROR("4042", "评论添加失败！"),

    // 系统操作
    VERIFY_CODE_PNG_IP_NULL("4101", "IP异常，无法生成或校验验证码！"),
    VERIFY_CODE_PNG_INVALID("4101", "图片验证码错误或失效，请重试！"),
    TOKEN_CREATION_ERROR("4101", "登录TOKEN生成失败！"),
    TOKEN_VAL_ERROR("001006", "签名验证失败，请重新登录！"),
    TOKEN_IS_NULL_ERROR("001002", "TOKEN为空！"), // 前端使用不能修改
    TOKEN_GET_ERROR("001004", "TOKEN解析失败，请重新登录!"), // 前端使用不能修改
    TOKEN_READ_ERROR("4112", "TOKEN解析失败！"),
    CONFIG_INFO_NULL("4101", "配置信息不存在！")

    /* end */;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
