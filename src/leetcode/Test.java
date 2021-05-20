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

    public int findTheLongestSubstring(String s) {
        int n = s.length();
        // 第一位记录 a 的统计结果，第二位记录e的统计结果，依次类推。这个二进制最大就是五个1，转成十进制就是31，申请一个长度32的数组。
        int[] pos = new int[1<<5];
        Arrays.fill(pos, -1);
        int ans = 0;
        int status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            // status是前i位，元音出现次数的一个统计结果
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]); // 此种奇偶统计状态第一次出现的位置
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
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
        test.findTheLongestSubstring("eleetminicoworoep");
    }
}
