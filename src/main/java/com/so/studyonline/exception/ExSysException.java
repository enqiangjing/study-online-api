package com.so.studyonline.exception;

import com.so.studyonline.config.ErrorCode;

/**
 * 自定义用户相关异常处理
 */
public class ExSysException extends ExBaseException {
    public ExSysException(ErrorCode ec) {
        super("system", ec.getCode(), ec.getMessage());
    }

    public ExSysException(String code, Object[] args, String defaultMessage) {
        super("system", code, args, defaultMessage);
    }

    public ExSysException(String code, Object[] args) {
        super("system", code, args);
    }

    public ExSysException(String code, String defaultMessage) {
        super("system", code, defaultMessage);
    }

    public ExSysException(String defaultMessage) {
        super("system", defaultMessage);
    }
}
