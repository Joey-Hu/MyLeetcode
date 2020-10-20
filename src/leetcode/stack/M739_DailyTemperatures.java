package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/7 10:38
 * @desc: https://leetcode.com/problems/daily-temperatures/
 */
public class M739_DailyTemperatures {

    /**
     * 单调栈
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length-1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
