package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 17:08
 * @desc: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock2 {

    /**
     * 双指针
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;

    }
}
