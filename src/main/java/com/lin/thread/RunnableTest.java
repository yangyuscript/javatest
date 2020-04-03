package com.lin.thread;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 17:22 2020/3/31
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadTest run "+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        RunnableTest test = new RunnableTest();
        RunnableTest test2 = new RunnableTest();
        new Thread(test).start();
        new Thread(test2).start();
    }
}
