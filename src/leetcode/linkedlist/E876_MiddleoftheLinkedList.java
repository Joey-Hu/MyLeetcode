package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/3 9:34
 * @desc: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class E876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // fast != null for odd，fast.next != null for even
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

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
