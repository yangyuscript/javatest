package com.lin.java8.functionalinterface;

/**
 * @Desc: 函数式接口之构造函数引用
 * @Author: lingx
 * @Date: 1:17 2020/1/16
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public static void main(String[] args) {
        PersonFactory<Person> pf = Person::new;
        Person p = pf.create("lin","tony");
    }
}
