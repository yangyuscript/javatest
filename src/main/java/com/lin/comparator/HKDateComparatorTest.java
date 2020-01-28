package com.lin.comparator;

import java.util.*;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/8 23:44
 * @Modified By:
 **/
public class HKDateComparatorTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("START_DATE","2019/08/01");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("START_DATE","2019/08/04");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("START_DATE","2019/08/07");

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map2);
        list.add(map);
        list.add(map3);
        System.out.println("排序前:"+list);
        Collections.sort(list,new HKDateComparator("START_DATE"));
        System.out.println("排序后:"+list);
    }
}
