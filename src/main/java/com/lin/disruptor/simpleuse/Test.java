package com.lin.disruptor.simpleuse;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:37 2020/4/5
 */
public class Test {
    public static void main(String[] args) {
        EventFactory<LongEvent> eventEventFactory = new LongEventFactory();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int ringBufferSize = 1024 * 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventEventFactory,ringBufferSize,executorService, ProducerType.SINGLE,new YieldingWaitStrategy());
        EventHandler<LongEvent> eventEventHandler = new LongEventHandler();
        disruptor.handleEventsWith(eventEventHandler);
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();
        try{
            LongEvent event = ringBuffer.get(sequence);
            long data = 1000;
            event.set(data);
        }finally {
            ringBuffer.publish(sequence);
        }

        disruptor.shutdown();
        executorService.shutdown();
    }
}
