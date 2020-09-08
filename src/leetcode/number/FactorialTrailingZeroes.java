package leetcode.number;

import LCCI.FactorialZeros;

/**
 * @author: huhao
 * @time: 2020/9/4 14:51
 * @desc: https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    /**
     * 求 1 - n 之间有多少个5， 10 = 2 * 5，一个；25 = 5 * 5, 两个
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        if (n == 0) {
            return 0;
        }

        int res = 0;

        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        new FactorialZeros().trailingZeroes(5);
    }
}
