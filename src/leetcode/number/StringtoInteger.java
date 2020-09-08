package leetcode.number;

/**
 * @author: huhao
 * @time: 2020/9/4 13:29
 * @desc: https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringtoInteger {

    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int res = 0;

        if (str.length() == 0) {
            return 0;
        }

        // 去掉空格
        while (i < str.length() && str.charAt(i) == ' ') {
            i ++;
        }

        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '-') ? -1 : 1;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 边界条件判断
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer
                    .MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res * sign;
    }
}
