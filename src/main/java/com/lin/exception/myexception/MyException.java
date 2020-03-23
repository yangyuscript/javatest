package com.lin.exception.myexception;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:36 2020/2/5
 */
public class MyException extends Exception {
    private long errorCode;
    private String errorMsg;

    public MyException(long errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "程序异常："+errorCode+","+errorMsg;
    }
}
