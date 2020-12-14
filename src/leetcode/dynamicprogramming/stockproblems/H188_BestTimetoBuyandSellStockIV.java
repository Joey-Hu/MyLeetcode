package leetcode.dynamicprogramming.stockproblems;

/**
 * @author: huhao
 * @time: 2020/9/15 16:40
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class H188_BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        // 当k很大时相当于不限制次数
        if (k > prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += Math.max(0, prices[i] - prices[i-1]);
            }
            return max;
        }

        int[][] dp0 = new int[prices.length][k+1];
        int[][] dp1 = new int[prices.length][k+1];

        for(int j = 0; j <= k; j++) {
            // i = 0
            dp1[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            dp0[i][0] = Math.max(dp0[i-1][0], -prices[i]);

            for (int j = 1; j <= k; j++) {
                dp0[i][j] = Math.max(dp0[i-1][j], dp1[i-1][j-1] + prices[i]);
                dp1[i][j] = Math.max(dp1[i-1][j], dp0[i-1][j] - prices[i]);
            }
        }
        return dp0[prices.length-1][k];
    }
}
