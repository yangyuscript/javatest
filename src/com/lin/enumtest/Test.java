package com.lin.enumtest;

import java.util.Collections;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/29 17:34
 * @Modified By:
 **/
public class Test {
    enum RemainType {
        High,Consume,Interim,GroupPreSuspend
    }


    public static void main(String[] args) {


        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 1;
            }
        };

        System.out.println(threadLocal.get());
    }
}
