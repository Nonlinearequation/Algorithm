package 数据结构实现.大话数据结构.串;

import javafx.scene.shape.SVGPath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xi553
 */
public class StringC implements StringI {

    private char[] value;

    public StringC(String value) {
        this.value = value.toCharArray();
    }

    public void grow() {
        int len = value.length;
        int newLen = len + (len << 1);
        Arrays.copyOf(value, newLen);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (char c : value) {
            buffer.append(c);
        }
        return buffer.toString();
    }

    @Override
    public StringC strAssign(String achar) {
        return null;
    }

    @Override
    public StringC strCopy(StringC c) {
        return null;
    }

    @Override
    public void clearString(StringC c) {

    }

    @Override
    public boolean stringEmpty(StringC c) {
        return false;
    }

    @Override
    public int length() {
        return value.length;
    }

    /**
     * 比较 s和 t的字符的顺序。如英文字符，a>b，返回>0
     * 若串s>t，返回值>0，若串s=t，返回0，若串s<t，返回值<0
     * 本字符串为s
     *
     * @param t
     * @return
     */
    @Override
    public int strCompare(StringC t) {
        if (t == null) {
            throw new NullPointerException("传入内容不能为空");
        }
        if (t.length() == 0 && value.length == 0) {
            return 0;
        }
        char[] svalue = value;
        char[] tvalue = t.value;
        for (int i = 0; i < svalue.length; i++) {
            if ((svalue.length - 1) == i || (tvalue.length - 1) == i) {
                if (svalue.length < tvalue.length) {
                    return -1;
                } else if (tvalue.length < svalue.length) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (svalue[i] < tvalue[i]) {
                return -1;
            } else if (svalue[i] > tvalue[i]) {
                return 1;
            } else {
                if ((tvalue.length - 1) == i && svalue.length == tvalue.length) {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override
    public StringC concat(StringC s1, String s2) {
        return null;
    }

    /**
     * 若串s存在，1<=pos<=length(s)，且0<=len<=length(s)-pos+1，(加1是因为算上被截取的起始字符)
     * 返回串s的第pos个字符起长度为len的字符串
     *
     * @param s   被查询的串
     * @param pos 起始字符位置（从1开始）
     * @param len 截取长度
     * @return 截取后的字符串StringC
     */
    @Override
    public StringC subString(StringC s, int pos, int len) {

        return null;
    }

    /**
     * 使用kmp算法计算出要查询的子串find是否在被查询的主串s中
     * 核心在于：将主串的指针移动x个字符（x是匹配上的长度减去部分匹配表中的字符的匹配值）
     *
     * @param s    被查询的主串
     * @param find 查询的子串
     * @param pos  开始查询的字符位置
     * @return 如果有，返回第一次出现的位置索引，如果没有，返回
     */
    @Override
    public int index(String find, int pos) {
        int[] partialMatchTable = createPartialMatchTable(find);

        char[] svalue = value;
        char[] fvalue = find.toCharArray();
        /*i:主串的指针 j：子串的指针 moveCounts：移动被查询字符串的长度 matchCharCounts：记录已匹配的字符长度*/
        int i = pos, j = 0, moveCounts = 0, matchCharCounts = 0;

        while (i < svalue.length) {
            if (svalue[i] == fvalue[j]) {
                i++;
                j++;
                matchCharCounts++;
            } else if (j == 0) {
                i++;
            } else {
                moveCounts = matchCharCounts - partialMatchTable[j - 1];
                j -= moveCounts;
                matchCharCounts -= moveCounts;
            }

            if (j == fvalue.length) {
                return i - fvalue.length;
            }
        }
        return -1;
    }

    /**
     * 计算字符串的部分匹配值
     *
     * @param t
     * @return 部分匹配值
     */
    private int calcMatchValue(String t) {
        int length = t.length();
        String pre = t.substring(0, length - 1);
        String sub = t.substring(1);
        //遍历字符串，挨个截取判断是否前缀和后缀是否相同
        while (pre.length() > 0 && sub.length() > 0) {//为什么要两个都判断，不是对称的吗？
            if (pre.equals(sub)) {
                return pre.length();
            }
            //前后缀长度为1时，匹配值为0
            if (pre.length() == 1 && sub.length() == 1) {
                break;
            }
            pre = pre.substring(0, pre.length() - 1);
            sub = sub.substring(1, sub.length() - 1);
        }
        return 0;
    }

    /**
     * 定义一个字符串的部分匹配表
     *
     * @param t
     * @return
     */
    private int[] createPartialMatchTable(String t) {
        int[] arr = new int[t.length()];
        //一个字符的匹配值为0
        arr[0] = 0;
        int i = 1;
        while (i < t.length()) {
            arr[i] = calcMatchValue(t.substring(0, i++));
        }
        return arr;
    }

    @Override
    public StringC replace(StringC s, String t, StringC v) {
        return null;
    }

    @Override
    public StringC insert(StringC s, int pos, StringC t) {
        return null;
    }

    @Override
    public StringC delete(StringC s, int pos, int len) {
        return null;
    }
}
