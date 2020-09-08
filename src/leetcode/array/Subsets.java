package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/5 12:45
 * @desc: https://leetcode.com/problems/subsets/
 */
public class Subsets {

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(track, new ArrayList<Integer>(), nums, 0);
        return track;
    }

    private void backtrack(List<List<Integer>> track, ArrayList<Integer> tempList, int[] nums, int start) {
        track.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(track, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new Subsets().subsets(nums);
    }
}
