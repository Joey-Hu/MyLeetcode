package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/8 10:55
 * @desc: https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] < sum) {
                sum = nums[i];
                max = Math.max(max, sum);
            }else {
                sum += nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
