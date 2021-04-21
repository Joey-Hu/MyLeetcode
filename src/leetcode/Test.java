package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
public class Test {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[text1.length()][text2.length()];
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
        System.out.println(test.longestCommonSubsequence("abcde", "ace"));


    }
}
