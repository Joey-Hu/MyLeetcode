package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/13 10:23
 * @desc: https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
