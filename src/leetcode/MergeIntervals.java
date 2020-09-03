package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/3 21:10
 * @desc: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < intervals.length - 1; i++) {

            if (intervals[i][1] >= intervals[i+1][0] && intervals[i][1] < intervals[i+1][1]) {
                res.add()
            }

        }
    }
}
