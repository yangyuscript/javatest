package com.lin.disruptor.test;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 22:23 2020/4/5
 */
public interface EventPublisher {
    void publish(long data) throws Exception;
    void start() throws Exception;
    void stop() throws Exception;
}
