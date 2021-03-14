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
public class test {

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        ListNode oddCur = oddList;
        ListNode evenCur = evenList;

        // 分割链表
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                oddCur.next = new ListNode(head.val);
                oddCur = oddCur.next;
            }else {
                evenCur.next = new ListNode(head.val);
                evenCur = evenCur.next;
            }

            head = head.next;
            count ++;
        }

        // 逆转偶数链表
        evenCur = evenList.next;
        ListNode prev = null;
        while (evenCur != null) {
            ListNode next = evenCur.next;
            evenCur.next = prev;
            prev = evenCur;
            evenCur = next;
        }
        evenCur = prev;

        // 合并两个有序链表
        oddCur = oddList.next;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (oddCur != null && evenCur != null) {
            if (oddCur.val < evenCur.val) {
                cur.next = new ListNode(oddCur.val);
                oddCur = oddCur.next;
            }else {
                cur.next = new ListNode(evenCur.val);
                evenCur = evenCur.next;
            }
            cur = cur.next;
        }

        cur.next = oddCur == null ? evenCur : oddCur;

        return res.next;
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
        ListNode raw = new ListNode(1);
        ListNode cur = raw;
        int[] val = new int[]{8, 3, 6, 5, 4, 7, 2};
        for (int num : val) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        cur.next = null;

        // 输出原链表
        cur = raw;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

        System.out.println("*******");

        ListNode res = solution(raw);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

    }
}
