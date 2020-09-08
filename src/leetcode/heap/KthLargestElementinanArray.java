package leetcode.heap;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/6 15:45
 * @desc: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(new KthLargestElementinanArray().findKthLargest(nums, 2));
    }
}
