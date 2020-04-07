package com.lin.disruptor.test;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:27 2020/4/5
 */
public class Test {
    public static void main(String[] args) throws Exception{
        long dataCount = 1024*1024;
        CounterTracer tracer = new SimpleTracer(dataCount);
        TestHandler handler = new TestHandler(tracer);

        //EventPublisher eventPublisher = new DirectPublisher(handler);
        //EventPublisher eventPublisher = new BlockingQueuePublisher(dataCount,handler);
        EventPublisher eventPublisher = new DisruptorPublisher(1024*1024,handler);
        eventPublisher.start();
        tracer.start();

        //发布事件
        for (int i = 0; i < dataCount; i++) {
            eventPublisher.publish(i);
        }

        //等待事件处理完成
        tracer.waitForReached();
        eventPublisher.stop();

        //输出结果
        System.out.println(tracer.getMilliTimeSpan());
        
    }
}
