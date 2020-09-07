package leetcode;

/**
 * @author: huhao
 * @time: 2020/9/7 16:23
 * @desc: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {

    /**
     * 二分查找
     * O(logN)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        }
        int low = (target <= nums[nums.length - 1]) ? minIndex : 0;
        int high = (target > nums[nums.length - 1]) ? minIndex : nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (target > nums[mid]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return -1;
    }

    public int findMinIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
