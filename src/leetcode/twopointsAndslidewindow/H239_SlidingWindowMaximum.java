package leetcode.twopointsAndslidewindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: huhao
 * @time: 2020/11/2 8:03
 * @desc: https://leetcode.com/problems/sliding-window-maximum/
 */
public class H239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len-k+1];
        int idx = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果队首元素是i-k的话，表示窗口向右移了一步，则移除队首元素
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // 比较队尾元素和将要进来的值，如果小的话就都移除
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            // 若 i >= k-1，说明窗口大小正好是k，就需要将最大值(队尾元素)加入结果 res 中
            if (i >= k-1) {
                res[idx++] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};

        new H239_SlidingWindowMaximum().maxSlidingWindow(nums, 3);
    }
}
