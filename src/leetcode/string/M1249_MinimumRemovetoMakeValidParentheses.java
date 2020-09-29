package leetcode.string;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/29 20:12
 * @desc: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class M1249_MinimumRemovetoMakeValidParentheses {

    /**
     * stack and placeholder
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {

        StringBuilder res = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (res.charAt(i) == '(') {
                stack.push(i);
            }
            if (res.charAt(i) == ')') {
                // 忽略正确匹配的括号
                if (!stack.empty()) {
                    stack.pop();
                }else {
                    // 未匹配的')'
                    res.setCharAt(i, '*');
                }
            }
        }

        while (!stack.empty()) {
            // 未匹配的'('
            res.setCharAt(stack.pop(), '*');
        }

        return res.toString().replaceAll("\\*", "");
    }
}
