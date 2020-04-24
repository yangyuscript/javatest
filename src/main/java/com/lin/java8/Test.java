package com.lin.java8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 21:45 2020/4/15
 */
public class Test {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("TYPE","U");
        map.put("SYSDATE", LocalDateTime.now().toString());
        map.put("NUM","10");
        list.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("TYPE","U");
        map2.put("SYSDATE", LocalDateTime.now().toString());
        map2.put("NUM","10");
        list.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("TYPE","U");
        map3.put("SYSDATE", LocalDateTime.now().toString());
        map3.put("NUM","10");
        list.add(map3);

    }
}
