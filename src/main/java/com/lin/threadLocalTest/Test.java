package com.lin.threadLocalTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lingx
 * @Description:
 * @Date: Created in 2019/4/5 22:08
 * @Modified By:
 **/
public class Test {
    private ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Test test = new Test();
        test.produce();
    }

    public void produce(){
        int i = 0;
        while(i<100){
            Map<String,Object> currMap = threadLocal.get();
            if(null != currMap){
                for (Map.Entry<String,Object> entry:currMap.entrySet()) {
                    System.out.println("currMap is :"+entry.getKey()+" "+entry.getValue());
                }
            }
            Thread thread = new Thread(new MyThread(i));
            thread.start();
            i++;
        }
    }

    class MyThread implements Runnable{
        private int i;
        @Override
        public void run() {
            Map<String,Object> map = new HashMap<>();
            map.put("MyThread"+i,i);
            threadLocal.set(map);
            Map<String,Object> lateMap = threadLocal.get();
            if(null != lateMap){
                for (Map.Entry<String,Object> entry:lateMap.entrySet()) {
                    System.out.println("lateMap is :"+entry.getKey()+" "+entry.getValue());
                }
            }
        }

        public MyThread(int i) {
            this.i = i;
        }
    }
}
