package leetcode.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @author: huhao
 * @time: 2020/10/8 15:55
 * @desc: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class M24_SwapNodesinPairs {

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 拆分链表
        ListNode oddList = new ListNode(-1);
        ListNode oddCur = oddList;
        ListNode evenList = new ListNode(-1);
        ListNode evenCur = evenList;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            if (count % 2 == 1) {
                oddCur.next = new ListNode(cur.val);
                oddCur = oddCur.next;
            }else {
                evenCur.next = new ListNode(cur.val);
                evenCur = evenCur.next;
            }
            cur = cur.next;
            count ++;
        }

        // 合并链表
        ListNode dummy = new ListNode(-1);
        cur = dummy;
        oddCur = oddList.next;
        evenCur = evenList.next;

        while (oddCur != null && evenCur != null) {
            cur.next = new ListNode(evenCur.val);
            cur = cur.next;
            cur.next = new ListNode(oddCur.val);
            cur = cur.next;
            evenCur = evenCur.next;
            oddCur = oddCur.next;
        }

        if (oddCur != null) {
            cur.next = oddCur;
        }
        return dummy.next;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode swap1 = cur.next;
            ListNode swap2 = cur.next.next;
            swap1.next = swap2.next;
            cur.next = swap2;
            swap2.next = swap1;
            cur = swap1;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        swapPairs2(dummy.next);

    }
}
