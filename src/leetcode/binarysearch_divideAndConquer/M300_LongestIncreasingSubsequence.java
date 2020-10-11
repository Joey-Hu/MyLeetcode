package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/11 20:22
 * @desc: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class M300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int low = 0;
        int minLen = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                low = i;
            }else {
                minLen = Math.max(minLen, i - low + 1);
            }




        }
        return -1;

    }
}
