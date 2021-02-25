package 面试题练习;

import java.util.Arrays;

/**
 * 题867
 * @author xi553
 */
public class LeetCode转置矩阵 {
    public static void main(String[] args) {
        int[][] matrix =  {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrixb = transpose(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] matrix2 =  {{1,2,3},{4,5,6}};
        int[][] matrix22 = transpose(matrix2);
        for (int[] ints : matrix22) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
