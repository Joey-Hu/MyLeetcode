package leetcode.binarysearch;

/**
 * @author: huhao
 * @time: 2020/9/8 7:59
 * @desc: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionofElementinSortedArray {

    /**
     * 线性扫描
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};

        // 找到左边界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res[0] = i;
                break;
            }
        }

        // 如果左边界等于-1，表示nums中没有target
        if (res[0] == -1) {
            return res;
        }

        // 寻找右边界
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == target) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int low = 0;
        int high = nums.length - 1;

        // 左边界查找
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        if (nums[low] != target) {
            return res;
        }else {
            res[0] = low;
        }

        // 右边界查找
        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) /2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid;
            }
        }
        res[1] = high;
        return res;
    }
}
