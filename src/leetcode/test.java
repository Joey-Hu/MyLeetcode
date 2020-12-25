package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
public class test {

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, tempList, res, visited);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> res, boolean[] visited) {
        if (tempList.size() == nums.length && !res.contains(new ArrayList<>(tempList))) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true || (i > 0 && nums[i-1] == nums[i] && !visited[i-1])) {
                continue;
            }
            tempList.add(nums[i]);
            visited[i] = true;
            backtrack(nums, tempList, res, visited);
            tempList.remove(tempList.size()-1);
            visited[i] = false;
        }
    }
}
