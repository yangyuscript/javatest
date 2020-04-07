package com.lin.disruptor.test;


import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 13:36 2020/4/6
 */
public class DisruptorPublisher implements EventPublisher {

    private static final WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();

    private Disruptor<TestEvent> disruptor;
    private TestEventHandler handler;
    private RingBuffer<TestEvent> ringBuffer;
    private ExecutorService executorService;

    public DisruptorPublisher(int bufferSize,TestHandler handler){
        this.handler = new TestEventHandler(handler);
        executorService = Executors.newSingleThreadExecutor();
        disruptor = new Disruptor<TestEvent>(new TestEventFactory(),bufferSize,executorService, ProducerType.SINGLE,YIELDING_WAIT);
    }

    @Override
    public void publish(long data) throws Exception {
        long seq = ringBuffer.next();
        try {
            TestEvent evt = ringBuffer.get(seq);
            evt.set(data);
            System.out.println("Data: "+data);
        } finally {
            ringBuffer.publish(seq);
        }
    }

    @Override
    public void start() throws Exception {
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }

    @Override
    public void stop() throws Exception {
        disruptor.shutdown();
        executorService.shutdown();
    }


    private class TestEventHandler implements EventHandler<TestEvent> {

        private TestHandler handler;

        public TestEventHandler(TestHandler handler){
            this.handler = handler;
        }

        @Override
        public void onEvent(TestEvent testEvent, long l, boolean b) throws Exception {
            handler.process(testEvent);
        }
    }
}
