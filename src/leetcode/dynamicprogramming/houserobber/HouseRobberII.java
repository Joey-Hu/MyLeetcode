package leetcode.dynamicprogramming.houserobber;

/**
 * @author: huhao
 * @time: 2020/9/16 13:18
 * @desc: https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    /**
     * 分别去掉首尾元素，分别用house robber里的算法求一遍，求最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] leftKeep = new int[nums.length-1];
        int[] rightKeep = new int[nums.length-1];

        for (int i = 0; i < nums.length - 1; i++) {
            leftKeep[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            rightKeep[i-1] = nums[i];
        }

        return Math.max(robHelper(leftKeep), robHelper(rightKeep));
    }

    private int robHelper(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
