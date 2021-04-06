package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/11 20:22
 * @desc: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class M300_LongestIncreasingSubsequence {

    public int lengthOfLIS2(int[] nums) {
        // tails[i]表示的是所有长度为i+1的递增子序列中的最小的尾部
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = i + (j-i) / 2;
                // 找到最后一个大于x的tail
                if (tails[m] < x) {
                    i = m + 1;
                }else {
                    j = m;
                }
            }
            // 如果 tails[i-1] < x <= tails[i]，则更新tail[i]
            tails[i] = x;
            // 如果所有的tail都小于x，则将将x添加进去，并更新size
            if (i == size) {
                ++ size;
            }
        }
        return size;
    }

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

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3};
        new M300_LongestIncreasingSubsequence().lengthOfLIS2(nums);
    }


}
