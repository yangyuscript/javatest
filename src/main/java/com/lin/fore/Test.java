package com.lin.fore;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 10:27 2020/3/10
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String str:list) {
            System.out.println(a++);
            if(a == list.size()+1){
                System.out.println("最后一个元素了");
            }
        }
    }
}
