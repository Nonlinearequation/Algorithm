package 数据结构实现.邓俊辉;

/**
 * 邓老师二分查找进阶版，原版二分查找左右分支转向代价不平衡（右侧的查找成本更高）
 * 如果查找值find < 中间值，左侧的查找成本是1
 * 如果find > 中间值，右侧的查找成本是2
 * 所以可以改变二分查找分位点的位置，以达到提高查找效率的目的
 */
public class 二_1二分查找改进 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,9,10,22,34,56,78};
        int[] arr2 = {3,4,5};
        int find = 7;
        System.out.println("二分查找"+5+"的索引为:"+binary_search(arr2,5));
        System.out.println("二分查找，没有找到返回不大于被查找元素的最大索引："+binary_search_pro(arr2,5));
    }

    /*
     * 改进版，减小右转代价
     */
    private static int binary_search(int[] arr,int find){
        int lo = 0;
        int hi = arr.length-1;
        while(1<hi-lo){//缩短到1的时候退出
            int mid = (hi+lo)>>1;//等于(lo+hi)/2
            //[lo,mi) 或 [mi,hi)
            if(find<arr[mid]){
                hi = mid;
            }else{
                lo = mid;
            }
        }//出口时hi = lo+1 查找区间仅含一个元素A[lo]
        return find==arr[lo]?lo:-1;//返回命中元素的位置或-1
    }

    /*
     * 改进版pro 实现未找到的话，返回不大于find元素的最大索引
     */
    private static int binary_search_pro(int[] arr,int find){
        int lo = 0;
        int hi = arr.length-1;
        while(lo<hi){
            int mid = (lo+hi) >>1;
            if(find<arr[mid]){
                hi = mid;//[lo,mi)
            }else{
                lo = mid + 1;//(mi,hi)
            }
        }
        //出口时，arr[lo=hi]为大于find的最小元素
        return --lo;//故lo-1是不大于find的元素的最大索引
    }



}
