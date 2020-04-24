package com.lin.disruptor.ordertrade;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 模拟生产者，产生订单线程
 */
public class TradeTransactionPublisher implements Runnable {

    private Disruptor<TradeTransaction> disruptor;
    private CountDownLatch latch;
    /**
     * 模拟10000次交易的发生
     */
    private static int LOOP = 10000;

    public TradeTransactionPublisher(Disruptor<TradeTransaction> disruptor, CountDownLatch latch) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeTransactionEventTranslator tradeTransloator = new TradeTransactionEventTranslator();
        for(int i=0;i<LOOP;i++){
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
    }
}

class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {

    private Random random = new Random();

    public void translateTo(TradeTransaction event, long sequence) {
        this.generateTradeTransaction(event);
    }

    /**
     * 生成订单流水号逻辑
     */
    private TradeTransaction generateTradeTransaction(TradeTransaction trade) {
        trade.setId(random.nextInt() * 9999+"");
        return trade;
    }
}
