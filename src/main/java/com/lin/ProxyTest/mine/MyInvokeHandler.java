package com.lin.ProxyTest.mine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:37 2020/2/23
 */
public class MyInvokeHandler implements InvocationHandler {
    private String clazz;

    public MyInvokeHandler(String clazz){
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("myInvoke start");
        Class proxyClazz = Class.forName(clazz);
        method.invoke(proxyClazz.newInstance(),args);
        System.out.println("myInvoke end");
        return null;
    }
}
