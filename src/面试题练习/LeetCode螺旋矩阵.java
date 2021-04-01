package 面试题练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author xi553
 */
public class LeetCode螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix).forEach(e-> System.out.print(e));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        //m行n列的话，先获取行列
        int row = matrix.length;
        int line = matrix[0].length;
        int i = 0, j = 0;
        int top = 0, left = 0, right = matrix[0].length, bottom = matrix.length;
        while (i <= bottom && j <= right) {
            for (; j < right; j++) {
                result.add(matrix[i][j]);
            }
            top++;
            for (i++; i < bottom; i++) {
                result.add(matrix[i][j]);
            }
            right--;
            for (j--; j >= left; j--) {
                result.add(matrix[i][j]);
            }
            bottom--;
            for (i--; i >= top; i--) {
                result.add(matrix[i][j]);
            }
            left++;
        }
        return result;
    }

}
