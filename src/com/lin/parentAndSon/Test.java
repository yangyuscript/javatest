package com.lin.parentAndSon;

public class Test {
    public static void main(String[] args) {
        Parent p = new Son();
        ((Son)p).play();
    }
}
