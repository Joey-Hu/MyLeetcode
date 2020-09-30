package leetcode.binarysearch_divideAndConquer;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/30 17:50
 * @desc: https://leetcode.com/problems/find-the-duplicate-number/
 */
public class M287_FindtheDuplicateNumber {

    /**
     * sort + traverse
     * O(n)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
