package com.cui.spring.util;

public class ExceptionUtils {

    public static ServiceException getServiceException(ErrorCode errorCode){
        return new ServiceException(errorCode.getCode(), errorCode.getMsg());
    }

    public static ServiceException getServiceException(ErrorCode errorCode, String errorMsg){
        return new ServiceException(errorCode.getCode(), errorCode.getMsg());
    }

    public static ServiceException getServiceException(ErrorCode errorCode, Throwable throwable){
        return new ServiceException(errorCode.getCode(), errorCode.getMsg(), throwable);
    }
}
