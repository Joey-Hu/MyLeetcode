package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/10/27 10:39
 * @desc: https://leetcode.com/problems/target-sum/
 */
public class M494_TargetSum {

    /**
     * 递归
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }

        int res = 0;
        helper(nums, S, 0, res);
        return res;
    }

    private void helper(int[] nums, int S, int start, int res) {
        if (start >= nums.length) {
            if (S == 0) {
                res ++;
            }
            return;
        }

        helper(nums, S+nums[start], start+1, res);
        helper(nums, S-nums[start], start+1, res);
    }
}
