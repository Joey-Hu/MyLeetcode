package leetcode.string;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/29 10:14
 * @desc: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class E557_ReverseWordsinaStringIII {

    /**
     * 利用stack
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                stack.push(ch);
            }else {
                while (!stack.empty()) {
                    res.append(stack.pop());
                }
                res.append(' ');
            }
        }

        while (!stack.empty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    /**
     * 并不利用其他数据结构，就地逆转
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        char[] ca = s.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            char ch = ca[i];
            if (ch != ' ') {
                int j = i;
                while (j + 1 < ca.length && ca[j+1] != ' ') {
                    j ++;
                }
                reverse(ca, i, j);
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        while (i < j) {
            char temp = ca[j];
            ca[i] = ca[j];
            ca[j] = temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        new E557_ReverseWordsinaStringIII().reverseWords(s);
    }
}
