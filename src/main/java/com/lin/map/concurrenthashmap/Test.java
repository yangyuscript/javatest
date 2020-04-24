package com.lin.map.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:21 2020/4/10
 */
public class Test {
    public static void main(String[] args) {
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.putIfAbsent("a","a");
        map.putIfAbsent("a","b");
        System.out.println(map);
    }
}
