package com.lin.ProxyTest.mine;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:56 2020/2/23
 */
public class Cat implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("cat is eatting " + food);
    }

    @Override
    public void run() {
        System.out.println("cat is running");
    }

    @Override
    public void sleep() {
        System.out.println("cat is sleeping");
    }
}
