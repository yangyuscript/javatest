package com.lin.fore;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 10:27 2020/3/10
 */
public class Test {
    public static void main1(String[] args) {
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

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int i = 0;

        lab:
        for(int j =0;j<=2;j++){
            System.out.println(j);
            for ( i = 0; i < 4; i++) {
                if(i == 3){
                    //break;
                }
            }
            if(i==4){
                continue lab;
            }
        }

        System.out.println(i);
    }
}
