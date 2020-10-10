package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/10 10:00
 * @desc: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class H154_FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // 相比于153 Find Minimum in Rotated Sorted Array 多了此处一个判断
            // 此处为什么是high--，是由rotate的方式决定的
            if (nums[mid] == nums[high]) {
                high--;
            }else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}
