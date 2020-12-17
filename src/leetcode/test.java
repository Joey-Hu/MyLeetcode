package leetcode;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
public class test {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }else if (nums[mid] < target) {
                if (nums[low] < nums[high]) {
                    high = mid - 1;
                }else {

                }
            }

        }
    }
}
