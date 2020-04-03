package com.lin.thread;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 17:12 2020/3/31
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadTest run "+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        ThreadTest test2 = new ThreadTest();
        test.start();
        test2.start();
    }
}
