package leetcode.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/18 17:08
 * @desc: https://leetcode.com/problems/decode-string/
 */
public class M394_DecodeString {

    /**
     * 使用stack + dfs
     * @param s
     * @return
     */
    public String decodeString(String s) {
        String res = "";
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int idx = 0;

        while(idx < s.length()) {
            if (s.charAt(idx) < '9' && s.charAt(idx) > '0') {
                // 当是数字时，获得重复次数，并加入countStack中
                int repeatTimes = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    repeatTimes = repeatTimes * 10 + (s.charAt(idx) - '0');
                    idx ++;
                }
                countStack.push(repeatTimes);
            } else if (s.charAt(idx) == '[') {
                // 当是左括号时，先将原来的res入栈，记录括号中的字符串
                resStack.push(res);
                res = "";
                idx ++;
            } else if (s.charAt(idx) == ']') {
                // 当是右括号时，累加res
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                // 如果是普通字符，就累加到res中
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new M394_DecodeString().decodeString("as3[a]2[bc]d");
    }
}
