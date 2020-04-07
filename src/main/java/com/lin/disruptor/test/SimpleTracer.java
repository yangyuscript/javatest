package com.lin.disruptor.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 21:46 2020/4/5
 */
public class SimpleTracer implements CounterTracer {

    private long startTicks;
    private long endTicks;
    private long count = 0;
    private boolean end = false;
    private final long expectedCount;
    private CountDownLatch latch = new CountDownLatch(1);

    public SimpleTracer(long expectedCount){
        this.expectedCount = expectedCount;
    }


    @Override
    public void start() {
        startTicks = System.currentTimeMillis();
        end = false;
    }

    @Override
    public long getMilliTimeSpan() {
        return endTicks - startTicks;
    }

    @Override
    public boolean count() {
        if(end){
            return end;
        }
        count++;
        end = count >= expectedCount;
        if(end){
            endTicks = System.currentTimeMillis();
            latch.countDown();
        }
        return end;
    }

    @Override
    public void waitForReached() throws InterruptedException{
        latch.await();
    }
}
