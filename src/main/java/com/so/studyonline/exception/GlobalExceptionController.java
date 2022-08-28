package com.so.studyonline.exception;

import com.so.studyonline.enhance.ResMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理控制器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * Exception 异常处理
     *
     * @param e 异常信息
     * @return 处理后的错误信息
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String SysErrorHandler(Exception e) {
        log.error("系统错误：", e);
        return ResMessage.error();
    }

    /**
     * ExUserException 异常处理
     *
     * @param ex 异常信息
     * @return 处理后的错误信息
     */
    @ResponseBody
    @ExceptionHandler(value = ExUserException.class)
    public String ExUserException(ExUserException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        log.error("[ExUserException] [{} : {}]", code, message, ex);
        return ResMessage.error(ex.getCode(), ex.getMessage());
    }

    /**
     * ExSysException 异常处理
     *
     * @param ex 异常信息
     * @return 处理后的错误信息
     */
    @ResponseBody
    @ExceptionHandler(value = ExSysException.class)
    public String ExSysException(ExSysException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        log.error("[ExSysException] [{} : {}]", code, message, ex);
        return ResMessage.error(ex.getCode(), ex.getMessage());
    }
}
