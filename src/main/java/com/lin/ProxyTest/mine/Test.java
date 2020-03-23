package com.lin.ProxyTest.mine;

import java.lang.reflect.Proxy;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:43 2020/2/23
 */
public class Test {
    public static void main(String[] args) {
        MyInvokeHandler myInvokeHandler = new MyInvokeHandler("com.lin.ProxyTest.mine.Dog");
        Animal dog = (Animal) Proxy.newProxyInstance(myInvokeHandler.getClass().getClassLoader(), new Class[]{Animal.class}, myInvokeHandler);
        dog.eat("apple");

        MyInvokeHandler myInvokeHandler1 = new MyInvokeHandler("com.lin.ProxyTest.mine.Cat");
        Animal cat = (Animal)Proxy.newProxyInstance(myInvokeHandler.getClass().getClassLoader(),new Class[]{Animal.class},myInvokeHandler1);
        cat.eat("apple");
    }
}
