package com.lin.classtest;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/3 10:16
 * @Modified By:
 **/
public class ClassTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.lin.classtest.ClassTest");
            System.out.println("haha");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
