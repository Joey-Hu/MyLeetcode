package leetcode.twopointsAndslidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/16 15:22
 * @desc: https://leetcode.com/problems/4sum/
 */
public class M18_FourSum {

    /**
     * 和 2sum，3sum类似，只是多一层循环
     * O(N^3)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int low = j+1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        if (!res.contains(Arrays.asList(nums[i], nums[j], nums[low], nums[high]))) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        }
                        low ++;
                        high --;
                    } else if (sum > target) {
                        high --;
                    } else {
                        low ++;
                    }
                }

            }

        }
        return res;
    }
}
