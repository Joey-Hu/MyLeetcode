package leetcode;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/6 9:27
 * @desc: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    /**
     * O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 当字符属于左半边字符集时，入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                // 匹配
                if (stack.empty()) {
                    return false;
                }
                 Character top = stack.pop();
                if (s.charAt(i) == ')' && top != '(') {
                    return false;
                }
                if (s.charAt(i) == ']' && top != '[') {
                    return false;
                }
                if (s.charAt(i) == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("(){}}{");
    }
}
