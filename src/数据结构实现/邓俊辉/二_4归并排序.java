package 数据结构实现.邓俊辉;

import java.util.Arrays;

public class 二_4归并排序 {
    public static void main(String[] args) {
        int[] arr1 = {5,4,3,1,6,9,23,45,32,11,26,10,34};
        int[] arr2 = {45,56,45,45,62,3,1,9,77,66,88,4,9,85,62,3,56,78,656,99,232,65,454,878,2,213,5656,95,2,23,45};
        int[] arr = {1,5,6,4,2};
        mergeSort(arr2,0,arr2.length);
        System.out.println(Arrays.toString(arr2));
    }

    private static void mergeSort(int[] arr,int lo, int hi){
        if(hi-lo<2) {
            return;//一个元素自然有序
        }
        int mi = (lo+hi)>>1;
        mergeSort(arr,lo,mi);//对前半段排序
        mergeSort(arr,mi,hi);//对后半段排序
        merge(arr,lo,mi,hi);
    }

    private static void merge(int[] arr,int lo,int mi,int hi){
        //前子向量，a中元素位置小于mi的部分,a[0,lb] = arr[lo,mi)
        int lb = mi - lo;
        int[] b = new int[lb];
        //复制前子向量b
        int temp = lo;
        for(int i=0;i<lb;i++) {
            b[i]=arr[temp++];
        }
        //后子向量c[0,lb) = arr[mi,hi)
        int lc = hi - mi;
        //c++的指针，在这里用索引+循环变量ijk的方式代替
        //c++代码中T* A = _elem+lo; 相当于i=0+lo;
        //T* C = _elem+mi; 相当于k=k+mi
        for(int i=lo,j=0,k=0;(j<lb)||(k<lc);){//b[j]和c[k]中小者转至a的末尾
            if((j<lb) && (lc<=k||(b[j]<=arr[mi+k]))){//c[k]中已无或b<=c,将b的值赋给arr
                arr[i++] = b[j++];
            }
            if((k<lc) && (lb<=j||(arr[mi+k]<b[j]))){//b[j]中已无或c<b,将c的值赋给arr
                arr[i++] = arr[mi+k++];
            }
        }
    }


}
