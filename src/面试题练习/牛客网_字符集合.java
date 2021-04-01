package 面试题练习;

import java.util.*;

/**
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */
public class 牛客网_字符集合 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.next());
        }
        for (String s : list) {
            String getstr = unique(s);
            System.out.println(getstr);
        }

    }
    private static String unique(String s){
        String[] list = s.split("");
        StringBuffer sb = new StringBuffer();
        for (String s1 : list) {
            if(sb.indexOf(s1)==-1){
                sb.append(s1);
            }
        }
        return sb.toString();
    }
}
