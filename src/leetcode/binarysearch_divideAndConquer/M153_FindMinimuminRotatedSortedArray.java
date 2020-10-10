package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/10 9:43
 * @desc: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class M153_FindMinimuminRotatedSortedArray {

    /**
     * 注意条件
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}
