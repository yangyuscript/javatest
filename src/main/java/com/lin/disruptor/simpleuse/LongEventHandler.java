package com.lin.disruptor.simpleuse;


import com.lin.disruptor.simpleuse.LongEvent;
import com.lmax.disruptor.EventHandler;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:32 2020/4/5
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event: " + longEvent);
    }
}
