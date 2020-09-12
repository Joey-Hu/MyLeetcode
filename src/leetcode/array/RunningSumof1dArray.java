package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/9/12 10:38
 * @desc: https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumof1dArray {

    public int[] runningSum(int[] nums) {
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            nums[i] = preSum;
        }
        return nums;
    }
}
