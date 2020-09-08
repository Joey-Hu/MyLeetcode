package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/8 15:26
 * @desc: https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=n; i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
