package leetcode.twopointsAndslidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/16 15:22
 * @desc: https://leetcode.com/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length-3; i++) {
            if (i==0 || (i > 0 && nums[i] != nums[i-1])) {
                for (int j = i+1; j < nums.length-2; j++) {
                    if (nums[j] != nums[j-1]) {
                        int low = j+1;
                        int high = nums.length - 1;
                        while (low < high) {
                            int sum = nums[i] + nums[j] + nums[low] + nums[high];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] != nums[low+1]) {
                                    low ++;
                                }
                                while (low < high && nums[high] != nums[high-1]) {
                                    high --;
                                }
                                low ++;
                                high --;
                            } else if (sum > target) {
                                while (low < high && nums[high] != nums[high-1]) {
                                    high --;
                                }
                                high --;
                            } else {
                                while (low < high && nums[low] != nums[low+1]) {
                                    low ++;
                                }
                                low ++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
