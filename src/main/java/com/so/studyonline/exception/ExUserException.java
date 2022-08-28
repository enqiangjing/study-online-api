package com.so.studyonline.exception;

import com.so.studyonline.config.ErrorCode;

/**
 * 自定义用户相关异常处理
 */
public class ExUserException extends ExBaseException {
    public ExUserException(ErrorCode ec) {
        super("user", ec.getCode(), ec.getMessage());
    }

    public ExUserException(String code, Object[] args, String defaultMessage) {
        super("user", code, args, defaultMessage);
    }

    public ExUserException(String code, Object[] args) {
        super("user", code, args);
    }

    public ExUserException(String code, String defaultMessage) {
        super("user", code, defaultMessage);
    }

    public ExUserException(String defaultMessage) {
        super("user", defaultMessage);
    }
}
