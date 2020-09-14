package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/12 9:13
 * @desc:
 */
public class Test {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 0) {
            return res;
        }

        // 左边界
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        res[0] = low;

        // 右边界
        high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        res[1] = high;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        new Test().searchRange(nums, 8);
    }
}
