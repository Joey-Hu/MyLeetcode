package leetcode.dynamicprogramming.houserobber;

/**
 * @author: huhao
 * @time: 2020/9/16 12:43
 * @desc: https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {

    /**
     * 动态规划
     * 状态方程：dp[i] = max{nums[i] + dp[i-2], dp[i-1]}
     * 初始化：dp[0] = nums[0]; dp[1] = max{nums[0], nums[1]}
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length < 1) {
            return nums.length == 0 ? 0 : nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        new HouseRobber().rob(nums);
    }
}
