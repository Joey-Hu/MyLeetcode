package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/5 13:47
 * @desc: https://leetcode.com/problems/permutations-ii/
 */
public class M47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(track, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return track;

    }

    private void backtrack(List<List<Integer>> track, ArrayList<Integer> tempList, int[] nums, boolean[] isUsed) {
        // 结束条件
        if (tempList.size() == nums.length) {
            track.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                // 排除不合法选择
                if (isUsed[i] == true || i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]) {
                    continue;
                }
                tempList.add(nums[i]);
                isUsed[i] = true;
                backtrack(track, tempList, nums, isUsed);
                isUsed[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
