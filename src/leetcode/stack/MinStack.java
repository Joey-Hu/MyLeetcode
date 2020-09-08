package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/6 10:25
 * @desc: https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    private Stack<Integer> stack;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        // 每次压入最小值之前，先压入次小值
        if (x <= min) {
            min = x;
            stack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        // 每次弹出最小值，后面跟着弹出次小值
        // 若判断出来是非最小值，也是弹出来了
        if (stack.pop().equals(min)) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return min;
    }
}
