package com.lin.exception.myexception;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:45 2020/2/5
 */
public class MyExceptionTest {
    public static void main(String[] args) throws Exception{
        throw new MyException(1001,"this is my exception");
    }
}
