package LCOF;

/**
 * @author: huhao
 * @time: 2020/10/28 19:56
 * @desc: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class LCOF14_I_cutRope {

    /**
     * DP
     * dp 数组定义为将长度为i的绳子建成m段之后得到的最大乘积
     * 初始化 dp[0] = 0, dp[1] = 0
     * 状态转移：当n >= 2时，长度为i的绳子可以切分为j（j取0到i-1）和i-j(也可以再分)两段,
     *  将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
     *  将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
     *
     * 因此，当 j 固定时，有 dp[i]=max(j×(i−j),j×dp[i−j])。由于 j 的取值范围是 1 到 i−1，需要遍历所有的 j 得到 dp[i] 的最大值，因此可以得到状态转移方程如下：
     * dp[i]= \max_{1≤j<i} {(j×(i−j),j×dp[i−j])}
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
