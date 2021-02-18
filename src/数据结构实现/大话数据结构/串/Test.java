package 数据结构实现.大话数据结构.串;

import java.util.HashMap;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        StringC aaa = new StringC("abasdabcde");
        aaa.grow();
//        System.out.println(aaa);
//        System.out.println(aaa.strCompare(new StringC("abc")));
//        System.out.println(aaa.strCompare(new StringC("x")));
//        System.out.println(aaa.strCompare(new StringC("abcdea")));
//        System.out.println(aaa.strCompare(new StringC("aberf")));
//        System.out.println(aaa.strCompare(new StringC("abcde")));

        System.out.println(aaa.index("abc",0));

        TreeMap<String,Object> map = new TreeMap<>();


    }


}
