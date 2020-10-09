package leetcode.linkedlist;


import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/9 11:26
 * @desc: https://leetcode.com/problems/reorder-list/
 */
public class M143_ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // find the middle of the list
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        // reverse the half after middle 1->2->3->4->5->6 to 1->2->3->4->null 6->5
        second = reverse(second);
        // insert the elements of the list1 into list1 one by one
        ListNode first = head;
        while (second != null) {
            ListNode next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    class ListNode {
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
}
