package leetcode.dynamicprogramming.stockproblems;

/**
 * @author: huhao
 * @time: 2020/9/15 16:54
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int[] dp0 = new int[prices.length];
        int[] dp1 = new int[prices.length];
        int[] cooled = new int[prices.length];

        dp1[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0[i] = Math.max(dp0[i-1], dp1[i-1] + prices[i]);
            dp1[i] = Math.max(dp1[i-1], cooled[i-1] - prices[i]);
            cooled[i] = Math.max(cooled[i-1], dp0[i-1]);
        }
        return dp0[prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        new BestTimetoBuyandSellStockwithCooldown().maxProfit(prices);
    }
}
