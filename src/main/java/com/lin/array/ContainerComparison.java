package com.lin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/22 11:15
 * @Modified By:
 **/
public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0,1,2,3,4,5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        char[] chars = new char[5];
        System.out.println(Arrays.toString(chars));
        System.out.println(chars[4]);


        List<Integer> integerList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
        integerList.add(97);
        System.out.println(integerList);
        System.out.println(integerList.get(4));

        BerylliumSphere[] a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        test(a);
    }

    public static void test(BerylliumSphere[] a){
        System.out.println(Arrays.toString(a));
    }
}
