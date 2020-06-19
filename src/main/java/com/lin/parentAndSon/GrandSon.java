package com.lin.parentAndSon;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 16:10 2020/2/26
 */
public class GrandSon extends Son{

    public GrandSon(){
        System.out.println("create a grandSon");
    }

    @Override
    public void eat(String food) {
        super.eat(food);
    }

    @Override
    public void drink(String drink) {
        super.drink(drink);
    }

    @Override
    public void add(Long b) {
        super.add(b);
    }

    @Override
    public void play() {
        super.play();
    }

    public static void main(String[] args) {
        GrandSon grandSon = new GrandSon();
        AtomicBoolean a = new AtomicBoolean();
        System.out.println(a.get());
    }
}
