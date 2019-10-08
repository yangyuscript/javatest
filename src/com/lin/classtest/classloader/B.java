package com.lin.classtest.classloader;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/4 10:31
 * @Modified By:
 **/
public class B {
    B(){
        System.out.println("B-new");
    }

    static{
        System.out.println("B-static-1");
    }

    {
        System.out.println("B-1");
    }
}
