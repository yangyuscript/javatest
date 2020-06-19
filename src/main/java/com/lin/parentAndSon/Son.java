package com.lin.parentAndSon;

public class Son extends Parent{
    private String school;

    private long a;

    public Son(String name, Integer age) {
        super(name, age);
    }

    public Son() {
        System.out.println("init son...");
    }

    public Son(String name, Integer age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void eat(String food) {
        System.out.println("son eat"+food);
    }

    @Override
    public void drink(String drink) {
        System.out.println("son drink "+drink);
    }

    public void add(Long b){
        System.out.println(b+this.a);
    }

    public void play(){
        System.out.println("play games");
    }
    public static void main(String[] args) {
        //Parent son = new Son();
        //son.start();
        Son s1 =new Son();
        //s1.add(10L);
    }
}
