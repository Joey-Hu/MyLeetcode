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
public class Test {

    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length()-1; i ++) {
            int len1 = palindromeLen(s, i, i);
            int len2 = palindromeLen(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - maxLen / 2;
            }
        }
        return s.substring(start, start+maxLen+1);
    }

    private int palindromeLen(String s, int idx1, int idx2) {
        int res = 0;
        if (idx1 == idx2) {
            res ++;
            idx1 --;
            idx2 ++;
        }
        while (idx1 >= 0 && idx2 < s.length()) {
            if (s.charAt(idx1) == s.charAt(idx2)) {
                res += 2;
                idx1 --;
                idx2 ++;
            }else {
                break;
            }
        }
        return res;
    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 创建链表
//        ListNode raw = new ListNode(1);
//        ListNode cur = raw;
//        int[] val = new int[]{8, 3, 6, 5, 4, 7, 2};
//        for (int num : val) {
//            cur.next = new ListNode(num);
//            cur = cur.next;
//        }
//        cur.next = null;

        Test test = new Test();
        System.out.println(test.longestPalindrome("cbbd"));


    }
}
