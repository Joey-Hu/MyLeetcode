package leetcode.number;

/**
 * @author: huhao
 * @time: 2020/9/4 11:30
 * @desc: https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            int newRes = res * 10 + digit;
            // 溢出情况
            if ((newRes - digit) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }
}
