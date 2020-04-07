package com.lin.disruptor.test;

import com.lmax.disruptor.EventFactory;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 13:55 2020/4/6
 */
public class TestEventFactory implements EventFactory<TestEvent> {
    @Override
    public TestEvent newInstance() {
        return new TestEvent();
    }
}
