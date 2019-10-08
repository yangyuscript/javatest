package com.lin.parentAndSon;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parent implements Comparable<Parent>{
    private String name;
    private Integer age;

    public Parent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Parent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void eat(String food){
        System.out.println("parent eat "+food);
    }

    public void drink(String drink){
        System.out.println("parent drink "+drink);
    }

    public void start(){
        drink("apple juice");
        eat("potato");
    }

    @Override
    public String toString() {
        return "Parent[name="+this.name+",age="+this.age+"]";
    }

    @Override
    public int compareTo(Parent o) {
        System.out.println(o.getName()+o.getAge().compareTo(this.age));
        return this.age-o.getAge()>0?-1:1;
    }

    public static void main(String[] args) {
        List<Parent> list = new LinkedList<>();
        list.add(new Parent("b",21));
        list.add(new Parent("a",21));
        list.add(new Parent("c",27));
        Collections.sort(list);
        for (Parent p:list) {
            System.out.println(p);
        }
        System.out.println("-------");
        Collections.sort(list, new Comparator<Parent>() {
            @Override
            public int compare(Parent o1, Parent o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (Parent p:list) {
            System.out.println(p);
        }
    }
}
