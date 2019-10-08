package com.lin.recursion;

public class Main {
    public int[] reverseStackRecursively(int[] stack, int top) {
        // write code here
        int start=0;
        int end=top;
        return getResult(stack,start,end);
    }
    public int[] getResult(int[] stack,int start,int end){
        if(start>=end){
            return stack;
        }else{
            int temp=stack[start];
            stack[start]=stack[end];
            stack[end]=temp;
            getResult(stack,++start,--end);
        }
        return stack;
    }
    public static void main(String[] args) {

    }
}
