package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/12/8 22:02
 * @desc: https://leetcode.com/problems/arranging-coins/
 */
public class E441_ArrangingCoins {

    /**
     * 加和
     * O(N)
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        double sum = 0;
        int coins = 0;
        while (sum <= n) {
            coins ++;
            sum += coins;
        }
        return coins-1;
    }


}
