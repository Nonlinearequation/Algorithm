package 面试题练习;

import java.util.Arrays;

/**
 * [[1,1,0],[1,0,1],[0,0,0]]
 * @author xi553
 */
public class LeetCode翻转图像 {
    public static void main(String[] args) {
        int[][] x = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] x2 = flipAndInvertImage(x);
        for (int[] ints : x2) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] y = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        y = flipAndInvertImage(y);
        for (int[] ints : y) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 做法：遍历每行，左右翻转一下
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     * 做法：数组A的元素加上1，再对2取余数
     *
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int horizon = A[0].length;
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<horizon;j++){
                if(j<horizon/2) {
                    int temp = A[i][j];
                    A[i][j] = A[i][horizon - j - 1];
                    A[i][horizon - j - 1] = temp;
                }
                int temp = A[i][j];
                A[i][j] = (temp + 1)%2;
            }
        }
        return A;
    }
}
