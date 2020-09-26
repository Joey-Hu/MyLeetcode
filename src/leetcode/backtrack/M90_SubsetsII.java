package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/5 13:19
 * @desc: https://leetcode.com/problems/subsets-ii/
 */
public class M90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(track, new ArrayList<Integer>(), nums, 0);
        return track;

    }

    private void backtrack(List<List<Integer>> track, ArrayList<Integer> tempList, int[] nums, int start) {
        track.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            // skip the duplicate element
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(track, tempList, nums, i + 1);
            tempList.remove(tempList.size()-1);
        }
    }

}
