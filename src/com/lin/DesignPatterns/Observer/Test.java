package com.lin.DesignPatterns.Observer;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/7/21 11:57
 * @Modified By:
 **/
public class Test {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber = new Subscriber(publisher);

        publisher.setData("hello world");
    }
}
