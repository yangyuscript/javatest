package com.lin.thread.pool;

import java.util.concurrent.*;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 10:28 2020/4/2
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        ExecutorService cached = Executors.newCachedThreadPool();
        ExecutorService scheduled = Executors.newScheduledThreadPool(2);
        ExecutorService single = Executors.newSingleThreadExecutor();
        ExecutorService my = new ThreadPoolExecutor(2,10,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100));
    }
}
