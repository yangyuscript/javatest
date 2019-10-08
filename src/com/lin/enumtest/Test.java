package com.lin.enumtest;

import java.util.Collections;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/29 17:34
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println("hello world");
        Color[] colors = Color.class.getEnumConstants();
        for (Color c:colors) {
            System.out.println(c.getCode()+" "+c.getDesc());
            System.out.println(c);
        }
    }
}
