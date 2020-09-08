package leetcode.backtrack;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/5 13:35
 * @desc: https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> track = new ArrayList<>();

        backtrack(nums, track, new ArrayList<Integer>());
        return track;
    }

    private void backtrack(int[] nums, List<List<Integer>> track, ArrayList<Integer> tempList) {
        // 结束条件
        if (tempList.size() == nums.length) {
            track.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(nums, track, tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
