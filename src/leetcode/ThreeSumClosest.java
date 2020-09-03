package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/3 15:59
 * @desc: https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length && minDiff != 0; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(minDiff)) {
                    minDiff = target - sum;
                }
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return target - minDiff;
    }
}
