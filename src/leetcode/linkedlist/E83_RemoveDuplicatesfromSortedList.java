package leetcode.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @author: huhao
 * @time: 2020/10/8 17:45
 * @desc: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class E83_RemoveDuplicatesfromSortedList {

    /**
     * 简单，一遍过
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur!= null && cur.next != null){
            ListNode next = cur.next;
            if (next.val == cur.val) {
                cur.next = next.next;
                continue;
            }else {
                cur = cur.next;
            }
        }
        return head;
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
