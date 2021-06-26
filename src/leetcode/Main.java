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

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        String res= "";

        for (int i = 0; i < s.length()-1; i ++) {
            int len1 = helper(s, i, i+1);
            int len2 = helper(s, i, i);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (maxLen-1) / 2;
                end = i + maxLen / 2;
                
                res = s.substring(start, end);
            }
        }
        return res;
    }

    private int helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Main().longestPalindrome("babad"));
    }


}


