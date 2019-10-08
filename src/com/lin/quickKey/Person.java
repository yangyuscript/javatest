package com.lin.quickKey;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static void main(String[] args) throws Exception{
        /*Set set = new HashSet<>();
        boolean a = set.add("a");
        boolean b = set.add("a");
        boolean c = set.add("c");
        System.out.println(a+" "+b+" "+c);*/

        /*long test = 43;
        System.out.println(-test);*/

        /*String fileName = new String("½ð¶îÊäÈë²»ºÏ·¨£º³äÖµ½ð¶îÐ¡ÓÚ10»ò´óÓÚ2000Ôª\\".getBytes("ISO8859-1"),"UTF-8");
        System.out.println(fileName);

        Person person = new Person();*/

        String startTime = "201807";
        System.out.println(startTime.substring(0, 4) + "-" + startTime.substring(4) + "-01");

        String endTime = "201812";
        System.out.println(endTime.substring(0, 4) + "-" + endTime.substring(4, 6) + "-" + endTime.substring(6) + " 23:59:59");



    }
}
