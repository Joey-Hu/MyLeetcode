package leetcode.dynamicprogramming.stockproblems;

/**
 * @author: huhao
 * @time: 2020/9/15 15:28
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;

    }
}
