package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/9 22:19
 * @desc: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class M81_SearchinRotatedSortedArrayII {

    /**
     * 如果可以有重复值，就会出现来面两种情况，[3 1 1] 和 [1 1 3 1]，
     * 对于这两种情况中间值等于最右值时，目标值3既可以在左边又可以在右边，那怎么办么，
     * 对于这种情况其实处理非常简单，只要把最右值向左一位即可继续循环，如果还相同则继续移，直到移到不同值为止，
     * 然后其他部分还采用 Search in Rotated Sorted Array 中的方法
     * 参考：https://www.cnblogs.com/grandyang/p/4325840.html
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[high]) {
                // target在右半边
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                }else { // target在左半边
                    high = mid - 1;
                }
            }else if (nums[mid] > nums[high]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                high --;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        new M81_SearchinRotatedSortedArrayII().search(nums, 5);
    }
}
