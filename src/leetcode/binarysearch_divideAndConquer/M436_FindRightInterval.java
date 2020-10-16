package leetcode.binarysearch_divideAndConquer;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author: huhao
 * @time: 2020/10/16 16:17
 * @desc: https://leetcode.com/problems/find-right-interval/
 */
public class M436_FindRightInterval {

    /**
     * treeMap 实现元素的自动排序
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {

        int[] res = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            res[i] = entry == null ? -1 : entry.getValue();
         }
         return res;
    }
}
