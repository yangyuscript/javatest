package com.lin.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 17:25 2020/3/31
 */
public class CallableTest implements Callable<Map<String,Object>> {
    @Override
    public Map<String, Object> call() throws Exception {
        System.out.println("ThreadTest run "+Thread.currentThread().getName());
        Map<String,Object> map = new HashMap<>();
        map.put("A","a");
        return map;
    }

    public static void main(String[] args) throws Exception{
        Callable<Map<String,Object>> callable = new CallableTest();
        Callable<Map<String,Object>> callable1 = new CallableTest();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        Map<String,Object> map = (Map)futureTask.get();
        System.out.println(map);

    }
}
