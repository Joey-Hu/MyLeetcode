package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/27 16:20
 * @desc: https://leetcode.com/problems/basic-calculator-ii/
 */
public class M227_BasicCalculatorII {
    /**
     * 使用一个栈来保存数字；
     * 如果该数字前是加或减号，则把当前数字或者是相反数压入栈
     * 如果该数字前是乘号或除号，那么从栈顶取出一个数字和当前数字进行乘或除的运算，再把结果压入栈中，
     * 那么完成一遍遍历后，所有的乘或除都运算完了，再把栈中所有的数字都加起来就是最终结果了
     * @param s
     * @return
     */
    public int calculate(String s) {
        int res = 0;
        int number = 0;
        Stack<Integer> stack = new Stack<>();
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            }
            if ((c != ' ' && !Character.isDigit(c) ) || i == s.length()-1){
                if (op == '+') {
                    stack.push(number);
                }
                if (op == '-') {
                    stack.push(-number);
                }
                if (op == '*' || op == '/') {
                    int temp = (op == '*') ? stack.peek() * number : stack.peek() / number;
                    stack.pop();
                    stack.push(temp);
                }
                op = c;
                number = 0;
            }
        }
        while (!stack.empty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        new M227_BasicCalculatorII().calculate(s);
    }

}
