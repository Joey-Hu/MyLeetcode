package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
import java.util.*;
public class Main {

    public String reverseStringInStack(String s) {
//        int idx = 0;
//        String res= "";
        Stack<Integer> stack = new Stack<>();
        char[] chArray = s.toCharArray();

        for (int i = 0; i < chArray.length; i ++) {
            char ch = chArray[i];
            if (ch == '(') {
                stack.push(i);
            }else if (ch == ')') {
                int start = stack.pop();
                reverse(chArray, start+1, i-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chArray.length; i ++) {
            if (chArray[i] == '(' || chArray[i] == ')') {
                continue;
            }
            sb.append(chArray[i]);
        }
        return sb.toString();
    }

    private void reverse(char[] charArray, int left, int right) {
//        char[] charArray = s.toCharArray();

        while (left < right) {
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().reverseStringInStack("a(bcdefghijkl(mno)p)q"));
    }


}


