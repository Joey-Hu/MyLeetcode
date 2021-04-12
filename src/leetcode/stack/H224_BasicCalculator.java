package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/6 11:01
 * @desc: https://leetcode.com/problems/basic-calculator/
 */
public class H224_BasicCalculator {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            }else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }else if (c == '(') {
                // 先将结果和sign压入栈
                stack.push(result);
                stack.push(sign);
                // 重置sign和result
                sign = 1;
                result = 0;
            } else if (c == ')') {
                // 此时的result是该对括号内部的result
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

//    private int calculateWithoutSpace(String s) {
//
//        int sum = 0;
//        Stack<Character> operator = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) > '0' && s.charAt(i) < '9' && !operator.empty()) {
//                if (operator.peek() == '+') {
//                    sum += Integer.valueOf(s.charAt(i) - '0');
//                    operator.pop();
//                } else {
//                    sum -= Integer.valueOf(s.charAt(i) - '0');
//                    operator.pop();
//                }
//            } else if (s.charAt(i) > '0' && s.charAt(i) < '9' && operator.empty()) {
//                sum += Integer.valueOf(s.charAt(i) - '0');
//            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
//                operator.push(s.charAt(i));
//            }
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println(new H224_BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
