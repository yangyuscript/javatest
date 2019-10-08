package com.lin.juc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/9/9 22:09
 * @Modified By:
 **/
public class test {
    public static void main(String[] args) {
        long[] a = new long[]{190911005168142L, 190911005168148L,
                190911005168149L,
                190911005168151L,
                190911005168152L,
                190911005168153L,
                190911005168154L,
                190911005168155L,
                190911005168157L,
                190911005168159L};

        Map<Long, List<Long>> map = new HashMap<>();
        for (long num:a) {
            long key = num%10;
            if(map.containsKey(key)){
                map.get(key).add(num);
            }else{
                List<Long> list = new LinkedList<>();
                list.add(num);
                map.put(key,list);
            }
        }
        System.out.println(map);
    }
}
