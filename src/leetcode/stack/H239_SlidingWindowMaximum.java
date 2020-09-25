package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: huhao
 * @time: 2020/9/24 20:30
 * @desc: https://leetcode.com/problems/sliding-window-maximum/
 */
public class H239_SlidingWindowMaximum {

    /**
     * 单调队列，类似于单调栈
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len-k+1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
        }
        return null;
    }

}
