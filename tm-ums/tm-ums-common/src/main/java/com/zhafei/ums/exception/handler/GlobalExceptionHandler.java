package com.zhafei.ums.exception.handler;

import com.zhafei.ums.exception.UmsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * 统一全局异常处理
 * @author yyf
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleException(Throwable e){
        // 打印堆栈信息
        return buildResponseEntity(null);
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = UmsException.class)
    public ResponseEntity<Object> badRequestException(UmsException e) {
        // 打印堆栈信息
        return buildResponseEntity(null);
    }

    /**
     * 统一返回
     */
    private ResponseEntity<Object> buildResponseEntity(Object obj) {
        return new ResponseEntity<>(new HashMap<String,String>(){
            {
                put("出现异常","500");
            }
        }, HttpStatus.valueOf(500));
    }
}
