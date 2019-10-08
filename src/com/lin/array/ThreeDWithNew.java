package com.lin.array;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/8/22 21:51
 * @Modified By:
 **/
public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));

        int[][] b = new int[2][3];
        System.out.println(Arrays.deepToString(b));

        int[][] c = new int[2][];
        c[0] = new int[2];
        c[0][0] = 1;
        c[0][1] = 2;
        System.out.println(Arrays.deepToString(c));

        int[][][] d = new int[2][][];
        d[0] = new int[1][];
        d[0][0] = new int[]{1,2};
        System.out.println(Arrays.deepToString(d));

    }
}
