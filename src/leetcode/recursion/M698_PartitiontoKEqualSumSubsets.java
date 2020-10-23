package leetcode.recursion;


import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/23 13:43
 * @desc: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class M698_PartitiontoKEqualSumSubsets {

    /**
     * backtracking
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        boolean[] isUsed = new boolean[nums.length];

        // 计算target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // corner case
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        // 排序
        Arrays.sort(nums);
        return partitionHelper(nums, isUsed, k, target, 0, 0);

    }

    private boolean partitionHelper(int[] nums, boolean[] isUsed, int k, int target, int curSum, int start) {
        // 终止条件1：当 k==1 时，表示剩下的元素可以一定可以组成一个 subSet
        if (k == 1) {
            return true;
        }
        // 终止条件2：没有这一组subSet
        // if (curSum > target) {
        //     return false;
        // }
        // 终止条件3：又找到一组subSet
        if (curSum == target) {
            return partitionHelper(nums, isUsed, k-1, target, 0, 0);
        }

        for (int i = start; i < nums.length; i++) {
            if (!isUsed[i] && curSum + nums[i] <= target) {
                isUsed[i] = true;
                if (partitionHelper(nums, isUsed, k, target, curSum+nums[i], i+1)) {
                    return true;
                }
                isUsed[i] = false;
            }
        }
        return false;
    }
}
