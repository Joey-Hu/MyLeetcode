package leetcode.array;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/5 14:20
 * @desc: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class M581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int[] clone = nums.clone();
        Arrays.sort(nums);

        while (left < nums.length && nums[left] == clone[left]) {
            left++;
        }

        while (right > left && nums[right] == clone[right]) {
            right--;
        }
        return right - left + 1;

    }
}
