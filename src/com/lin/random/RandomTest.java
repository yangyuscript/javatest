package com.lin.random;

import java.util.Random;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/23 15:11
 * @Modified By:
 **/
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);

        int a = (int)Math.random()*10;
        System.out.println(a);
    }
}
