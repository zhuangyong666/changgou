package com.zy.handler;

import com.zy.entity.Result;
import com.zy.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(StatusCode.SYSTEMERROR);
    }
}
