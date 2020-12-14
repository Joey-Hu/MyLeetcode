package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/8 9:15
 * @desc: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class E1351_CountNegativeNumbersinaSortedMatrix {

    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            count += countNegWithBS(grid[i]);
        }

        return count;
    }

    public int countNegWithBS(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= 0) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        if (nums[low] >= 0) {
            return 0;
        }else {
            return nums.length - low;
        }
    }
}
