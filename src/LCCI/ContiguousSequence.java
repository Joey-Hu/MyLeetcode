package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/25 22:10
 * @desc: https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 */
public class ContiguousSequence {

    /**
     * 动态规划
     * 每一个数据都有两个选择，与前面相连或者自己另立门户
     * 所以状态转移方程就是 dp[i] = Math.max(dp[i - 1] + nums[i],nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        new ContiguousSequence().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
