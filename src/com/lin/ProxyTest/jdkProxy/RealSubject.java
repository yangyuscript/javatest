package com.lin.ProxyTest.jdkProxy;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/5/1 13:59
 * @Modified By:
 **/
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
