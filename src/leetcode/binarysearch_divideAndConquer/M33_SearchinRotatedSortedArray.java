package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/7 16:23
 * @desc: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class M33_SearchinRotatedSortedArray {

    /**
     * 二分查找
     * 先找到最小值的下标，然后根据最后一个元素与target的大小
     * 确定是在左半边找(target > nums[len-1])还是在右半边(target <= nums[len-1])找
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
        int high = (target <= nums[nums.length - 1]) ? nums.length-1 : minIndex;

        // 基本的二分查找
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (target > nums[mid]) {
                low = mid + 1;
            }else {
                high = mid-1;
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
