package com.zhafei.ums.exception.handler;

import com.zhafei.ums.exception.UmsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        e.printStackTrace();
        return buildResponseEntity(null);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> methodNotSupportHandle(HttpRequestMethodNotSupportedException e) {
        return buildResponseEntity("不支持的请求方法");
    }
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = UmsException.class)
    public ResponseEntity<Object> badRequestException(UmsException e) {
        // 打印堆栈信息
        e.printStackTrace();
        return buildResponseEntity("自定义异常");
    }

    /**
     * 统一返回
     */
    private ResponseEntity<Object> buildResponseEntity(String mess) {
        return ResponseEntity.ok(mess);
    }
}
