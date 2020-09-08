package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 19:22
 * @desc: https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    /**
     * 暴力解法  略
     * 双指针
     * O(N)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                length = Math.min(length, i - low + 1);
                sum -= nums[low++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }


}
