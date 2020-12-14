package leetcode.combinearea;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/3 21:10
 * @desc: https://leetcode.com/problems/merge-intervals/
 */
public class M56_MergeIntervals {

    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // 按照起始节点大小排序
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {  // 重叠
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else {  // 不重叠
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
