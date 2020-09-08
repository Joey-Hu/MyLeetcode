package leetcode.dynamicprogramming;

import java.util.Vector;

/**
 * @author: huhao
 * @time: 2020/9/8 14:14
 * @desc: https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    /**
     * 动态规划
     * 类似于爬楼梯
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        // dp[i][j] 表示到point[i][j] 有多少种方法
        int[][] dp = new int[m][n];
        // 将dp[i][j] 全部初始化为1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        // 状态方程 dp[i][j] = dp[i-1][j] + dp[i][j-1];
        // 到point[i][j]只能由左边point[i-1][j]和上面point[i][j-1]得到
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
