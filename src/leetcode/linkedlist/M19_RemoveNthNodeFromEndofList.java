package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/8/31 22:26
 * @desc:
 */
public class M19_RemoveNthNodeFromEndofList {

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev, end = head;
        prev = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        // 当链表长度为1时
        if (end == null) {
            return head.next;
        }

        while (end.next != null) {
            end = end.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;
    }


    public class ListNode {
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
