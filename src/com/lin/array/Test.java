package com.lin.array;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/24 11:00
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i]=i+1;
        }
        int[] b = new int[5];
        for (int i = 0; i < b.length; i++) {
            b[i]=i+1;
        }

        label:
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(16==a[i]*a[j]){
                    a[i]=3;
                    b[j]=3;
                    continue label;
                }
            }
        }
    }
}
