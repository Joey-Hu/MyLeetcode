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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(nums, res, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
