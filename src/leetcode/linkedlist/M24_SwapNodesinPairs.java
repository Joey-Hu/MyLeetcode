package leetcode.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @author: huhao
 * @time: 2020/10/8 15:55
 * @desc: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class M24_SwapNodesinPairs {

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

    class ListNode {
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
}
