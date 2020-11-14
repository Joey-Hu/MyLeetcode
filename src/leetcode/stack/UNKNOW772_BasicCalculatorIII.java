package leetcode.stack;

/**
 * @author: huhao
 * @time: 2020/11/14 11:12
 * @desc: https://leetcode.com/problems/basic-calculator-iii/
 */

import java.util.Stack;

/**
 * The expression string contains only non-negative integers, +, -, *, / operators, open ( and closing parentheses ) and empty spaces.
 *
 * Examples:
 Input: "1 + 1"
 Return: 2
 Input: " 6-4 / 2 "
 Return: 4
 Input: "2*(5+5*2)/3+(6/2+8)"
 Return: 21
 Input: "(2+6* 3+5- (3*14/7+2)*5)+3"
 Return: -12
 */
public class UNKNOW772_BasicCalculatorIII {

    public int calculate(String s) {

        int res = 0;
        int curRes = 0;
        int number = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number += number * 10 + (int)(ch - '0');
            }else if (ch == '(') {
                int j = i;
                int count = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        count ++;
                    }else if (s.charAt(i) == ')') {
                        count --;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                number = calculate(s.substring(j+1, i+1));
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                switch (sign) {
                    case '+': curRes += number; break;
                    case '-': curRes -= number; break;
                    case '*': curRes *= number; break;
                    case '/': curRes /= number; break;
                }
                if (ch == '+' || ch == '-' || i == s.length()-1) {
                    res += curRes;
                    curRes = 0;
                }
                sign = ch;
                number = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new UNKNOW772_BasicCalculatorIII().calculate("(2*(3-4))*5");
    }
}
