package com.lin.disruptor.test;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 21:44 2020/4/5
 */
public interface CounterTracer {
    void start();
    long getMilliTimeSpan();
    boolean count();
    void waitForReached() throws InterruptedException;
}
