package 数据结构实现.大话数据结构.串;

public interface StringI {

    /**
     * 生成一个其职等于字符串常量achar的串
     * @param achar
     * @return
     */
    StringC strAssign(String achar);

    /**
     * 串c存在，由串c复制得到新串
     * @param c
     * @return
     */
    StringC strCopy(StringC c);

    /**
     * 清空串
     * @param c
     */
    void clearString(StringC c);

    /**
     * 若串为空返回 true，否则返回 false
     * @param c
     * @return
     */
    boolean stringEmpty(StringC c);

    /**
     * 串的长度
     * @return
     */
    int length();

    /**
     * 若串s>t，返回值>0，若串s=t，返回0，若串s<t，返回值<0。
     * 本字符串为s
     * @param t
     * @return
     */
    int strCompare(StringC t);

    /**
     * 返回由s1和s2拼接而成的新串
     * @param s1
     * @param s2
     * @return
     */
    StringC concat(StringC s1, String s2);

    /**
     * 若串s存在，1<=pos<=length(s)，且0<=len<=length(s)-pos+1，(加1是因为算上被截取的起始字符)
     * 返回串s的第pos个字符起长度为len的字符串
     * @param s 被查询的串
     * @param pos 起始字符位置（从1开始）
     * @param len 截取长度
     * @return 截取后的字符串StringC
     */
    StringC subString(StringC s, int pos, int len);

    /**
     * 串s和find存在，find是非空字符串，1<=pos<=length(s)。
     * 若串s中存在和find相同的子串，则返回它在主串s中第pos个字符之后第一次出现的位置，否则返回0
     * @param s 被查询的主串
     * @param find 查询的子串
     * @param pos 开始查询的字符位置
     * @return 子串第一次在主串中出现的位置
     */
    int index(String find, int pos);

    /**
     * 串s、t、v存在，t是非空字符串。用v替换s中所有与t值相等的不重叠的子串
     * @param s 主串
     * @param t 被替换的字符串
     * @param v 用于替换的字符串
     * @return 替换后的主串
     */
    StringC replace(StringC s, String t, StringC v);

    /**
     * 串s和t存在，1<=pos<=length(s)+1
     * 在串s的第pos个字符之前插入串t
     * @param s 主串
     * @param pos 插入的位置
     * @param t 子串
     * @return 插入新串的主串
     */
    StringC insert(StringC s, int pos, StringC t);

    /**
     * 若串s存在，1<=pos<=length(s)-len+1
     * 在主串中删除第pos个字符起长度为len的子串
     * @param s
     * @param pos
     * @param len
     * @return
     */
    StringC delete(StringC s, int pos, int len);


}
