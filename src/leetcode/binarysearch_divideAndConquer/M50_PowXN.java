package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/12/22 10:43
 * @desc: https://leetcode.com/problems/powx-n/
 */
public class M50_PowXN {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x*x, n / 2) : x * myPow(x * x, n / 2);
    }
}
