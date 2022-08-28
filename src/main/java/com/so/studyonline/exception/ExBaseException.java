package com.so.studyonline.exception;


import io.netty.util.internal.StringUtil;

/**
 * 自定义异常类，基础类
 */
public class ExBaseException extends RuntimeException {
    /**
     * 所属模块
     */
    private final String module;
    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误码对应的参数
     */
    private final Object[] args;

    /**
     * 错误消息
     */
    private final String defaultMessage;

    public ExBaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public ExBaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public ExBaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public ExBaseException(String module, String code, String defaultMessage) {
        this(module, code, null, defaultMessage);
    }

    public ExBaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public ExBaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String message;
        if (!StringUtil.isNullOrEmpty(defaultMessage)) {
            message = defaultMessage;
        } else {
            message = code;
        }
        return message;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
