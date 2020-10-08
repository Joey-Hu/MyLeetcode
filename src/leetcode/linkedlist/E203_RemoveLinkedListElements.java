package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/9 7:02
 * @desc: https://leetcode.com/problems/remove-linked-list-elements/
 */
public class E203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode cur = dummy.next;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
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
