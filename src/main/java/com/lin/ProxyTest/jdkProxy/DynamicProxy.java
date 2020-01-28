package com.lin.ProxyTest.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/1 14:00
 * @Modified By:
 **/
public class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");

        System.out.println("Method:" + method);

        method.invoke(subject,args);

        System.out.println("after rent house");

        return null;
    }
}
