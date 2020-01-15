package com.lin.java8.lambda;

import java.util.*;

/**
 * @Desc: Lambda 表达式之排列字符串
 * @Author: lingx
 * @Date: 0:05 2020/1/16
 */
public class CompareTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("peter","tony","july","allen");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("traditional sort: "+list);

        Collections.sort(list,(String a,String b) -> {return a.compareTo(b);});

        Collections.sort(list,(String a,String b) -> a.compareTo(b));

        Collections.sort(list,(a,b) -> a.compareTo(b));
    }
}
