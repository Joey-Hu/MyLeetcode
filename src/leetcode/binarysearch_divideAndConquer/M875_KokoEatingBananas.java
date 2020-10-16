package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/16 18:42
 * @desc: https://leetcode.com/problems/koko-eating-bananas/
 */
public class M875_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = (int) 1e9;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int pile : piles) {
                count += (pile + mid - 1) / mid;
            }
            // 吃速慢了
            if (count > H) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return high;
    }
}
