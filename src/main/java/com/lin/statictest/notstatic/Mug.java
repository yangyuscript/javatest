package com.lin.statictest.notstatic;

public class Mug {
    Mug(int marker){
        System.out.println("Mug("+marker+")");
    }
    void f(int marker){
        System.out.println("f("+marker+")");
    }
}
