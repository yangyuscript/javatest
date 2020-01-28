package com.lin.classtest.shapetest;


/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/3 15:33
 * @Modified By:
 **/
public abstract class Shape {
    void draw(){
        System.out.println(this+".draw()");
    }

    @Override
    public abstract String toString();
}
