package 面试题练习;

public class LeetCode翻转数字 {

    public static void main(String[] args) {
        System.out.println(reverse(746384741));
        System.out.println(reverse2(214748364));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 我的思路：用stringbuffer的reverse方法，反转字符，然后再处理0
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        try {
            StringBuffer buffer = new StringBuffer(String.valueOf(x)).reverse();
            boolean isNagetive = false;
            int length;
            if (x < 0) {
                isNagetive = true;
                length = buffer.length() - 1;
            } else {
                length = buffer.length();
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                if (sb.length() == 0 && "0".equals(buffer.charAt(i))) {
                    continue;
                }
                sb.append(buffer.charAt(i));
            }
            Integer res = Integer.valueOf(sb.toString());
            if (isNagetive) {
                res *= -1;
            }
            return res;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 官方方法：用n%10取余得到最后一位，再n=n/10，结果 = 余数*10 + 下一次的余数
     * 处理int溢出问题，因为结果 = 余数*10 + 下一次的余数，所以即 ★余数*10 + 下一次的余数 < MAX_VALUE
     * 正数：第一种情况
     * 如果最后一次的余数<214748364(MAX_VALUE/10) ，那么乘以10再加上任意小于10的数都不会超过2147483647(MAX_VALUE)，
     * 例如余数=214748363，结果 = 214748363*10+9 = 2147483639<2147483647
     * 所以当最后一次的余数<214748364(MAX_VALUE/10)时，不回溢出正数范围
     * 正数：第二种情况
     * 如果余数=214748364(MAX_VALUE/10)，下一次的余数<7就不会溢出正数范围
     * ∴ 余数<MAX_VALUE/10 || (余数=MAX_VALUE/10 && 下一次的余数<7) 可以继续
     *
     * 负数，与正数对应的两种情况
     *
     * @param n
     * @return
     */
    private static final int NUM_TEN = 10;
    private static int reverse2(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % NUM_TEN;
            n /= NUM_TEN;
            if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && temp>7)||
               res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && temp<-8)){
                return 0;
            }
            res = res * NUM_TEN + temp;
        }
        return res;
    }

}
