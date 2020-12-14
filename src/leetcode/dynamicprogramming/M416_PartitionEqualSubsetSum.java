package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/16 16:04
 * @desc: https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class M416_PartitionEqualSubsetSum {

    /**
     * dp[i] 表示从数组中任意取数字的和能不能构成i
     * 状态转移方程：dp[i] = dp[i] || dp[i - nums[j]]
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }else {
            boolean dp[] = new boolean[sum + 1];
            int target = sum / 2;
            dp[0] = true;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[target];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        new M416_PartitionEqualSubsetSum().canPartition(nums);
    }
}
