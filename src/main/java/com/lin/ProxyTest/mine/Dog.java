package com.lin.ProxyTest.mine;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 14:35 2020/2/23
 */
public class Dog implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("dog is eatting" + food);
    }

    @Override
    public void run() {
        System.out.println("dog is running");
    }

    @Override
    public void sleep() {
        System.out.println("dog is sleeping");
    }
}
