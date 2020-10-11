package leetcode.twopointsAndslidewindow;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/11 18:50
 * @desc: https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class M209_MinimumSizeSubarraySum {

    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(minLen, i - low + 1);
                sum -= nums[low++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = low + 1;
        int minLen = Integer.MAX_VALUE;

        while (low < high && high < nums.length) {
            if (sumSubArray(nums, low, high) < s) {
                high ++;
            }else {
                minLen = Math.min(minLen, high - low + 1);
                low ++;
            }
        }
        return minLen;
    }

    private int sumSubArray(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
