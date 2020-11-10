package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/11 20:22
 * @desc: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class M300_LongestIncreasingSubsequence {

    /**
     * 动态规划
     * O(N^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        // dp[i] 表示到num[i]递增子序列的元素个数
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
