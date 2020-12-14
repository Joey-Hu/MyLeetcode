package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/6 9:49
 * @desc: https://leetcode.com/problems/longest-valid-parentheses/
 */
public class H32_LongestValidParentheses {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                // 不管有没有匹配到一个'()'，将')'出栈
                stack.pop();
                // 如果此时栈为空，将')'入栈
                if (stack.empty()) {
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new H32_LongestValidParentheses().longestValidParentheses("(()");
    }
}
