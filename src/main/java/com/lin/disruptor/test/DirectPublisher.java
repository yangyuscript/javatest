package com.lin.disruptor.test;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:24 2020/4/5
 */
public class DirectPublisher implements EventPublisher {

    private TestHandler handler;
    private TestEvent event = new TestEvent();

    public DirectPublisher(TestHandler handler) {
        this.handler = handler;
    }

    @Override
    public void publish(long data) throws Exception {
        event.set(data);
        System.out.println("data: "+data);
        handler.process(event);
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
