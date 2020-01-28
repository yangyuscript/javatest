package com.lin.threadfactory;

public abstract class Parent extends GrandPa {
    public Parent(){
        System.out.println("Parent init");
    }

    public abstract void run(String a);
}
