package leetcode.binarysearch_divideAndConquer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/30 17:50
 * @desc: https://leetcode.com/problems/find-the-duplicate-number/
 */
public class M287_FindtheDuplicateNumber {

    /**
     * set
     * O(N)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    /**
     * sort + traverse
     * O(nlogn)
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
