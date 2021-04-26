package 面试题练习;

import java.util.*;

/**
 * 题目描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 *
 * 请注意本题含有多组样例输入。
 *
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 */
public class 牛客网_蛇行矩阵{

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            List<Integer> inlist = new ArrayList<Integer>();
            while(sc.hasNext()){
                inlist.add(sc.nextInt());
            }

            for(int n:inlist){
                int[][] res = method(n);

                    for(int r=0;r<n;r++){
                        for(int l=0;l<n-r;l++){
                            if(res[r][l]>0){
                                System.out.print(res[r][l]+" ");
                            }
                        }
                    System.out.println();
                }
            }
        }

        private static int[][] method(int num){
            int[][] res = new int[num][num];
            //第一列的数据
            res[0][0] = 1;
            for(int i=1;i<num;i++){
                res[i][0] = i + res[i-1][0];
            }
            //第二列之后的数据
            for(int j=1;j<num;j++){
                for(int i=0;i<num-j;i++){
                    res[i][j] = res[i+1][j-1] + 1;
                }
            }
            return res;
        }


}
