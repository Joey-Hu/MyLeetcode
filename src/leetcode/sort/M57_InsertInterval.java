package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/21 10:48
 * @desc: https://leetcode.com/problems/insert-interval/
 */
public class M57_InsertInterval {

    /**
     * 用双指针找到 newInterval 与 intervals 中重叠的 intervals 的首尾
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>();
        int start = -1;
        int end = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                res.add(intervals[i]);
            }
            if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) {
                start = i;
            }
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
                end = i;
            }
        }

        // start == -1 表时没有找到能够包含（即intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]）的interval,
        // 则将左边界设置为newInterval的左边界；end == -1 同理
        int newLeft = start == -1 ? newInterval[0] : intervals[start][0];
        int newRight = end == -1 ? newInterval[1] : intervals[end][1];
        res.add(new int[]{newLeft, newRight});
        int[][] res1 = res.toArray(new int[0][]);
        Arrays.sort(res1, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        return res1;
    }
}
