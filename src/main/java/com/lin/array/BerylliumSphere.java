package com.lin.array;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/22 11:12
 * @Modified By:
 **/
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString(){
        return "Sphere "+id;
    }
}
