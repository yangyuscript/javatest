package com.lin.threadfactory;

public class Son extends Parent {
    public Son(){
        System.out.println("Son init");
    }

    @Override
    public void run(String a){
        System.out.println("Son run" + a);
    }

    public static void main(String[] args) {
        GrandPa s = new Son();
        ((Son) s).run("1");
    }
}
