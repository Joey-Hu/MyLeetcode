package leetcode.dynamicprogramming.stockproblems;

/**
 * @author: huhao
 * @time: 2020/9/15 14:57
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class E121_BestTimetoBuyandSellStock {

    /**
     * 状态转移方程 dp[i] = max{dp[i-1], prices[i]-min_price[i]}
     * dp[i]：表示到ith天为止能获得的最大利润
     * min_price[i] ：表示到ith天为止最小的价格
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int[] minPrice = new int[prices.length];
        dp[0] = 0;
        minPrice[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice[i-1]) {
                minPrice[i] = prices[i];
            } else {
                minPrice[i] = minPrice[i-1];
            }
            dp[i] = Math.max(dp[i-1], prices[i]-minPrice[i]);
        }
        return dp[prices.length-1];
    }
}
