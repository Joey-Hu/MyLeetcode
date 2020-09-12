package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/12 21:22
 * @desc: https://leetcode.com/problems/coin-change/
 */
public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        int res = 0;
        // dp[i]数组定义：当金额为i时，需要dp[i]枚硬币
        int[] dp = new int[amount+1];
        // 将dp初始化为amount+1：因为金额为i时，硬币数量最多的一种情况是都为一元硬币，数据量为amount，amount+1表示表示正无穷，
        // 以便后面取最小值
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        new CoinChange().coinChange(coins, 11);
    }
}
