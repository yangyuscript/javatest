package com.lin.disruptor.test;

import com.lin.annotation.Test;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 21:42 2020/4/5
 */
public class TestHandler {
    private CounterTracer tracer;

    public TestHandler(CounterTracer tracer){
        this.tracer = tracer;
    }

    public boolean process(TestEvent testEvent){
        return tracer.count();
    }
}
