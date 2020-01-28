package com.lin.threadfactory;

public abstract class GrandPa {
    public GrandPa(){
        System.out.println("init GrandPa");
    }

    public final void run(){
        System.out.println("GrandPa run");
    }
}
