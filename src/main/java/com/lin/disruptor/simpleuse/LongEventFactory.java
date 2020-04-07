package com.lin.disruptor.simpleuse;

import com.lin.disruptor.simpleuse.LongEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:31 2020/4/5
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
