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

        for (int i = 0; i < T.length; i++) {
            // 当 T[i] 大于栈顶元素所指的气温时，弹出栈顶元素（）
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new M739_DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
