package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 20:40
 * @desc: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class E876_MiddleoftheLinkedList {

    /**
     * 常规解法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while (cur!=null) {
            cur = cur.next;
            len ++;
        }

        cur = head;
        int index = 1;
        int middle = len / 2 + 1;
        while (index < middle) {
            cur = cur.next;
            index ++;
        }

        return cur;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

