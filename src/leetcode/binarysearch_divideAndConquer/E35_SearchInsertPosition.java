package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/9 20:51
 * @desc: https://leetcode.com/problems/search-insert-position/
 */
public class E35_SearchInsertPosition {

    /**
     * 当循环结束时，如果没有找到目标元素，那么low一定停在恰好比目标大的index上，high一定停在恰好比目标小的index上
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
       int low = 0;
       int high = nums.length - 1;

       while (low <= high) {
           int mid = low + (high - low) / 2;
           if (nums[mid] == target) {
               return mid;
           }else if (nums[mid] < target) {
               low = mid + 1;
           }else {
               high = mid - 1;
           }
       }
       return low;
    }
}
