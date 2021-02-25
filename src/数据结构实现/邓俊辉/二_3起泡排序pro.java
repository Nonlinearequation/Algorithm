package 数据结构实现.邓俊辉;

import java.util.Arrays;

/*
 * 可以检测出
 */
public class 二_3起泡排序pro {
    public static void main(String[] args) {
        int[] arr = {5,4,2,1,6,9,8,7,11,25,36};
        bubbleSortPro(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortPro(int[] arr){
        int lo = 0;
        int hi = arr.length;
        while(lo<(hi = bubble(arr,lo,hi))){//如果hi>lo，就一直扫描

        }
    }
    /**
     * 返回hi的位置 如果某段元素之后都不需要交换，那么将hi修改为需要交换的最短位置
     */
    private  static int bubble(int[] arr,int lo,int hi){
        int last = lo;//最右侧逆序对初始化为[lo-1,lo]
        while(++lo<hi){//自左向右 逐一检查 相当于for(int i=0;i<arr.length;i++)
            if(arr[lo-1]>arr[lo]){//如果逆序，则更新最右侧逆序对位置记录
                last = lo;//相当于last=i;
                int temp = arr[lo-1];//并交换位置
                arr[lo-1] = arr[lo];
                arr[lo] = temp;
            }

        }
        return last;//返回最右侧的逆序对位置
    }


}
