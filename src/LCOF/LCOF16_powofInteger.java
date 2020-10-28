package LCOF;

/**
 * @author: huhao
 * @time: 2020/10/28 20:33
 * @desc: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class LCOF16_powofInteger {

    /**
     * 二分
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        double res = 1;
        long b = n;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
