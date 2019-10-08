package com.lin.lambda;

import java.util.function.Consumer;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/9/20 10:42
 * @Modified By:
 **/
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        f.andThen(f2).accept("test");

        f.andThen(f).andThen(f).andThen(f).accept("test1");
    }
}
