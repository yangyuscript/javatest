package com.lin.disruptor.ordertrade;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * 处理订单入库线程
 */
public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction>, WorkHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction tradeTransaction, long l, boolean b) throws Exception {
        this.onEvent(tradeTransaction);
    }

    @Override
    public void onEvent(TradeTransaction tradeTransaction) throws Exception {
        String threadName = Thread.currentThread().getName();
        String id = tradeTransaction.getId();
        System.out.println("线程:" + threadName + "处理订单业务入库服务  ------> :  商品ID是 ：" + id);
    }
}
