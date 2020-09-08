package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 17:08
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock {

    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                i++;
                break;
            } else {
                for (int j = i + 1; j < prices.length; j++) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;

    }
}
