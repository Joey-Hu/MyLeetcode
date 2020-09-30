package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/30 17:22
 * @desc: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class M1011_CapacityToShipPackagesWithinDDays {

    /**
     * firstly, you need find the boundary of the possible weight capacity of the ship
     * find the smallest possible weight capacity of the ship using binary search
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {

        int left = 0;
        int right = 0;
        // left: maximum weight of array weights, which means minimum possible weight capacity of the ship
        // right: sum weight of array weights, which means maximum possible weight capacity of the ship
        for (int weight : weights) {
            left = Math.max(weight, left);
            right += weight;
        }

        // now we need to find the minimum weight capacity of the ship between left and right.
        while (left < right) {
            int mid = left + (right - left)/2;
            int need = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += weight;
            }
            // the possible weight capacity of the ship must be larger
            if (need > D) {
                left = mid + 1;
            }else { // the possible weight capacity of the ship can be smaller
                right = mid;
            }
        }
        return left;
    }
}
