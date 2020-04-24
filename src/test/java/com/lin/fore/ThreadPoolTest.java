package com.lin.fore;

import org.junit.Test;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    public void test2() throws Exception{
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch cd = new CountDownLatch(1);
        ExecutorService  myExecutor = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 100; i++) {
            //System.out.println(i);
            final int a = i;
            myExecutor.execute(() -> {
                exec(a);
                if(atomicInteger.incrementAndGet()>=100){
                    cd.countDown();
                }
            });
        }
        cd.await();
    }

    public static void exec(int a){
        System.out.println(Thread.currentThread().getName()+"开始执行"+String.valueOf(a)+"任务"+LocalDateTime.now().toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行结束"+String.valueOf(a)+"任务"+LocalDateTime.now().toString());

    }

    @Test
    public void test3() throws Exception{
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch cd = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            final int a = i;
           new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"开始执行"+String.valueOf(a)+"任务");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行结束"+String.valueOf(a)+"任务");
                if(atomicInteger.incrementAndGet()>=100){
                    cd.countDown();
                }
           }).start();
        }
        cd.await();
    }
}
