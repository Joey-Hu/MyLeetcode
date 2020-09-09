package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/9 20:33
 * @desc: https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, 0, target, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int start, int target, ArrayList<Integer> tempList) {

        if (target == 0) {
            res.add(new ArrayList(tempList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i-1] == candidates[i]){
                continue;
            }
            tempList.add(candidates[i]);
            backtrack(res, candidates, i+1, target - candidates[i], tempList);
            tempList.remove(tempList.size()-1);
        }
    }

}
