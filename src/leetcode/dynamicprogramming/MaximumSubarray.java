package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/8 10:55
 * @desc: https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 动态规划
     * 动态规划问题最主要的明确重叠子问题和状态转移方程
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        // dp[i]  表示以i结尾的maxSubArray
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
