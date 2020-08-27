package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/27 21:53
 * @desc:
 */
public class FactorialZeros {

    /**
     * 从1 —— n 之间有多少个5（比如 10=2*5: 一个5, 25=5*5: 两个5）
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
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        new FactorialZeros().trailingZeroes(30);
    }
}
