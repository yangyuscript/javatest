package com.lin.disruptor.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 12:56 2020/4/6
 */
public class BlockingQueuePublisher implements EventPublisher {

    private ArrayBlockingQueue<TestEvent> queue;
    private TestHandler testHandler;

    public BlockingQueuePublisher(long maxEventSize,TestHandler handler){
        this.queue = new ArrayBlockingQueue<>((int)maxEventSize);
        this.testHandler = handler;
    }

    @Override
    public void publish(long data) throws Exception {
        TestEvent evt = new TestEvent();
        evt.set(data);
        System.out.println("data: "+data);
        queue.put(evt);
    }

    @Override
    public void start() throws Exception {
        new Thread(() -> handle()).start();
    }

    @Override
    public void stop() throws Exception {

    }

    private void handle(){
        try {
            TestEvent evt;
            while(true){
                evt = queue.take();
                if(evt!=null && testHandler.process(evt)){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
