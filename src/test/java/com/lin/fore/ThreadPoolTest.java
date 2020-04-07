package com.lin.fore;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 10:58 2020/4/3
 */
public class ThreadPoolTest {
    @Test
    public void test() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> callable = () -> {
            Thread.sleep(3000);
            return Thread.currentThread().getName()+" haha";
        };
        System.out.println("执行 " + LocalDateTime.now());
        Future<String> future = executorService.submit(callable);
        System.out.println("获取值 " + LocalDateTime.now());
        System.out.println(future.get());
        System.out.println("获取后 " + LocalDateTime.now());
    }
}
