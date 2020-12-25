package leetcode.array;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/12/25 16:52
 * @desc: https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class M769_MaxChunksToMakeSorted {

    /**
     * 我们从左向右进行遍历，如果已经观测到的最大值小于等于这个区间的 index，那么就可以划分区间了
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int preMax = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > preMax) {
                preMax = arr[i];
            }

            if (preMax <= i) {
                res ++;
            }
        }
        return res;
    }
}
