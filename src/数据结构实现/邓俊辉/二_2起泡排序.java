package 数据结构实现.邓俊辉;

import java.util.Arrays;

public class 二_2起泡排序 {

    public static void main(String[] args) {
        int[] arr = {5,2,6,3,9,4,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr){
        int lo = 0;
        int hi = arr.length;
        while (!bubble(arr,lo,hi--)){//逐趟做扫描交换，直至完全有序，h--控制最坏情况下（完全逆序）的跳出
        }
    }

    /*
     * 每一次检查交换，hi控制循环的长度
     */
    private static boolean bubble(int[] arr,int lo,int hi){
        boolean sorted = true;
        while(++lo<hi){//相当于for(int i=0;i<arr.length;i++)
            if(arr[lo-1]>arr[lo]){
                sorted = false;
                int temp = arr[lo-1];
                arr[lo-1] = arr[lo];
                arr[lo] = temp;
            }
        }
        return sorted;
    }
}
