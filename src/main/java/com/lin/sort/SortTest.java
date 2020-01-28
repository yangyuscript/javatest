package com.lin.sort;

/**
 * @Description:
 * @Author: lingx
 * @Date: Created in 2019/10/5 17:17
 * @Modified By:
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] a = new int[]{2,1,5,3,7};
        System.out.print("排序前：");
        print(a);

        //bubbleSort(a);
        //chooseSort(a);
        //insertSort(a);
        quickSort(a,0,a.length-1);

        System.out.print("排序后：");
        print(a);
    }

    private static void print(int[] a){
        for (int t:a) {
            System.out.print(t+" ");
        }
        System.out.println();
    }

    /**
     *冒泡排序
     */
    private static void bubbleSort(int[] a){
        int len = a.length;
        for(int i = 0;i<len-1;i++){
            for(int j=i;j<len-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void chooseSort(int[] a){
        int len = a.length;
        for(int i=0;i<len-1;i++){
            int min = i;
            for(int j=i+1;j<len;j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            if(min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    /**
     * 插入排序：无序序列的第一个元素与有序序列从尾到头比较，找到合适的位置插入进去
     */
    private static void insertSort(int[] a){
        int len = a.length;
        for(int i = 1;i<len;i++){
            int temp = a[i];
            for(int j=i-1;j>=0;j--){
                if(a[j]>temp){
                    a[j+1] = a[j];
                    a[j] = temp;
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 快速排序（递归）：从数列中选择一个数，保证右边的数均小于等于该数且左边的数均大于等于该数
     */
    private static void quickSort(int[] a,int left,int right){
        if(left<right){
            int middle = getMiddlware(a,left,right);
            quickSort(a,left,middle-1);
            quickSort(a,middle+1,right);
        }
    }

    private static int getMiddlware(int[] a,int left,int right){
        int temp = a[left];
        while(left < right){
            while(left < right && a[right]>=temp){
                right--;
            }
            a[left] = a[right];
            while(left < right && a[left]<=temp){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }
}
