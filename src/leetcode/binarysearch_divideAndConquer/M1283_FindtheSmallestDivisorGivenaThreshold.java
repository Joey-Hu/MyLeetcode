package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/11/23 13:20
 * @desc: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class M1283_FindtheSmallestDivisorGivenaThreshold {

    /**
     * 二分搜索
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {

        int right = (int)1e6;
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int a = 0;
            for (int num : nums) {
                a += Math.ceil((1.0 * num) / mid);
            }
            if (a > threshold) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
