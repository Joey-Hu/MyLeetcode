package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/25 10:27
 * @desc: https://leetcode.com/problems/combinations/
 */
public class M77_Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        backtrack2(n, k, 1, tempList, res);

        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i ++) {
            if (tempList.contains(i)) {
                continue;
            }

            tempList.add(i);
            backtrack(n, k, i+1, tempList, res);
            tempList.remove(tempList.size()-1);
        }
    }

    /**
     * 与前一个方法区别在于循环遍历条件
     * @param n
     * @param k
     * @param start
     * @param tempList
     * @param res
     */
    private void backtrack2(int n, int k, int start, List<Integer> tempList, List<List<Integer>> res) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n - (k-tempList.size()) + 1; i ++) {

            tempList.add(i);
            backtrack2(n, k, i+1, tempList, res);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        new M77_Combinations().combine(4, 2);
    }
}
