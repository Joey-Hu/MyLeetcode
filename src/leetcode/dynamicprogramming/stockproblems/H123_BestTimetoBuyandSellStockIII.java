package leetcode.dynamicprogramming.stockproblems;

import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/15 15:53
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class H123_BestTimetoBuyandSellStockIII {

    /**
     * 参考：https://zhuanlan.zhihu.com/p/92908822
     * 即根据手头是否持有股票，我们定义两个二维数组来定义状态：
     * dp0[i][j]: 第i天结束，已有j次买卖，手头没有股票时的最大利润
     * dp1[i][j]: 第i天结束，已有j次买卖，手头有股票时的最大利润
     *
     * 初始化：
     * dp0[0][j]对于所有j都要初始化为0，而dp1[0][j]对于所有j都要初始化为-prices[i]
     *
     * 返回结果：
     * dp0[n-1][k]就是在最后一天结束时已进行k次交易且手头无股票时的最大收益，也即返回结果
     *
     * 状态转移方程：
     * dp0[i][j] = max(dp0[i-1][j], dp1[i-1][j-1] + prices[i])
     * 今天我没有持有股票，有两种可能：
     * 昨天我也没有股票，今天选择保持，所以今天也没有股票
     * 昨天我持有股票，今天选择卖出，所以我今天没有股票了
     *
     * dp1[i][j] = max(dp1[i-1][j], dp0[i-1][j] - prices[i])
     * 今天我持有股票，有两种可能：
     * 昨天我持有股票，今天选择保持，今天还有股票
     * 昨天我没有股票，今天选择买入，今天持有股票
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[][] dp0 = new int[prices.length][3];
        int[][] dp1 = new int[prices.length][3];

        dp1[0][0] = -prices[0];
        dp1[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // j=0
            dp1[i][0] = Math.max(dp1[i-1][0], -prices[i]);
            // j=1
            dp0[i][1] = Math.max(dp0[i-1][1], dp1[i-1][0] + prices[i]);
            dp1[i][1] = Math.max(dp1[i-1][1], dp0[i-1][1] - prices[i]);

            // j=2
            dp0[i][2] = Math.max(dp0[i-1][2], dp1[i-1][1] + prices[i]);
        }

        return dp0[prices.length-1][2];
    }
}
