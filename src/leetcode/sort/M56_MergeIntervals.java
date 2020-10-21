package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/21 9:47
 * @desc: https://leetcode.com/problems/merge-intervals/
 */
public class M56_MergeIntervals {

    /**
     * sort start points and end points
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // 因为按照下面的merge方法中的排序后，得到的和start与end单独排序的效果一样
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (i == intervals.length-1 || starts[i+1] > ends[i]) {
                res.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[0][]);
    }


        /**
         * 先排序，然后逐个合并
         * @param intervals
         * @return
         */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // 按照起始节点大小排序
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        // 先把第一个interval添加进res中
        res.add(intervals[0]);

        // 从第二个interval开始遍历
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 如果interval的start小于等于前一个interval的end, 则合并(更新end, 并赋值给前一个interval的end)
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
                res.get(res.size()-1)[1] = end;
            }else {
                // 否则，更新start和end, 并将此interval添加进res中
                start = interval[0];
                end = interval[1];
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        new M56_MergeIntervals().merge(intervals);
    }
}
