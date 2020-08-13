package LCCI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/11 22:24
 * @desc: https://leetcode-cn.com/problems/power-set-lcci/
 */
public class PowerSet {
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<Integer>(tempList));
        for(int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = powerSet.subsets(nums);
        System.out.println(subsets);

    }
}
