package com.lin.annotation;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/9/18 11:44
 * @Modified By:
 **/
public class Hero {
    @Deprecated
    public void say(){
        System.out.println("Nothing has to say!");
    }

    public void speak(){
        System.out.println("I have a dream!");
    }
}
