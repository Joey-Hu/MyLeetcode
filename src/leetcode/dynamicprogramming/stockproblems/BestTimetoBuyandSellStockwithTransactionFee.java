package leetcode.dynamicprogramming.stockproblems;

/**
 * @author: huhao
 * @time: 2020/9/15 17:14
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp0 = new int[prices.length];
        int[] dp1 = new int[prices.length];

        dp1[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp0[i] = Math.max(dp0[i-1], dp1[i-1] + prices[i] - fee);
            dp1[i] = Math.max(dp1[i-1], dp0[i-1] - prices[i]);
        }
        return dp0[prices.length-1];
    }
}
