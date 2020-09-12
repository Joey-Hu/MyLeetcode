package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/12 9:13
 * @desc:
 */
public class Test {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length-2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(nums[low] + nums[high] - target);
                    res = nums[low] + nums[high];
                }
                if (sum > target) {
                    high --;
                }
                if (sum < target) {
                    low ++;
                }
            }
        }
        return res;
    }
}
