package 面试题练习;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 0-9 对应0-9
 * A-F 对应 10-15
 *
 * 方法：
 * 十六进制数每一位乘以16的n次方相加
 */
public class 牛客网_华为面试题_十六进制数转十进制 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String r = null;
        if(sc.hasNext()){
            r = sc.next();
        }
        r = r.trim();
        int result = 0;
        String[] list = r.split("");
        int len = list.length;
        for (int i = 0; i < list.length; i++) {
            int temp = sixteenToTen(list[i]);
            result += temp * Math.pow(16,len-1);
            len--;
        }
        System.out.println(result);
    }

    private static int sixteenToTen(String s){
        s = s.trim();
        if(Pattern.matches("\\d",s)){
            return Integer.valueOf(s);
        }else{
            switch (s) {
                case "A": return 10;
                case "B": return 11;
                case "C": return 12;
                case "D": return 13;
                case "E": return 14;
                case "F": return 15;
                default:return 0;
            }
        }
    }


}
