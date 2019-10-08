package com.lin.classtest.classloader;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/4 10:31
 * @Modified By:
 **/
public class A extends B{
    A(){
        System.out.println("A-new");
    }

    {
        System.out.println("A-1");
    }

    static {
        System.out.println("A-static-1");
        new A();
    }

    public static void main(String[] args) {
        System.out.println("A-main");
    }

    static {
        System.out.println("A-static-2");
    }
}
