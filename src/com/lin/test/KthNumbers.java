package com.lin.test;

import java.util.Arrays;

public class KthNumbers {
    public static void main(String[] args) {
        int[] A={2,1,4,3};
        int[] r=findKthNumbers(A,4,2);
        for(int i=0;i<2;i++){
            System.out.println(r[i]);
        }
    }
    public static int[] findKthNumbers(int[] A, int n, int k) {
        // write code here
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=A[i];
        }

        int[] result=new int[k];
        Arrays.sort(A);

        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                if(A[i]==a[j]){
                    result[i]=j;
                    break;
                }
            }
        }
        Arrays.sort(result);
        for(int i=0;i<k;i++){
            result[i]=a[result[i]];
        }
        return result;
    }
}
