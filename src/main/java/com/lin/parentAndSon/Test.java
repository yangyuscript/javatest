package com.lin.parentAndSon;

public class Test {
    public static void main(String[] args) throws Exception{
        //Son son = (Son)Test.class.getClassLoader().loadClass("com.lin.parentAndSon.Son").newInstance();
        //Son son1 = (Son)Class.forName("com.lin.parentAndSon.Son").newInstance();
        //Son son2 = Son.class.newInstance();

        GrandSon gs = GrandSon.class.newInstance();
    }
}
