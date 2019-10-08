package com.lin.enumtest;

public class EnumDemo {

    public static void main(String[] args){
        Day day =Day.MONDAY;
        System.out.println(day);
    }

}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
