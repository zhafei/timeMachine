package com.zhafei.ums.exception;

/**
 * @author yyf
 * @version v1.0
 * @description 用户管理服务异常
 * @create 2021/4/6 16:15:42
 */
public class UmsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UmsException(String message){
        super(message);
    }

    public UmsException(Throwable cause)
    {
        super(cause);
    }

    public UmsException(String message,Throwable cause)
    {
        super(message,cause);
    }
}