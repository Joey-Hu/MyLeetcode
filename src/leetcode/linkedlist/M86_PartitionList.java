package leetcode.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @author: huhao
 * @time: 2020/10/8 19:50
 * @desc: https://leetcode.com/problems/partition-list/
 */
public class M86_PartitionList {

    // 一些边界条件出错
   /* public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        while (p != null && p.val != x) {
            p = p.next;
        }

        if (p == null) {
            return head;
        }

        ListNode prev = p;
        ListNode right = p.next;
        while (right != null) {
            if (right.val < x) {
                insertLeft(head, p, right.val);
                prev.next = right.next;
            }else {
                prev = right;
            }
            right = right.next;
        }
        return head;
    }

    private void insertLeft(ListNode head, ListNode p, int val) {
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != p.next) {
            if (prev.val <= val && cur.val > val) {
                ListNode newNode = new ListNode(val);
                prev.next = newNode;
                newNode.next = cur;
            }
            prev = cur;
            cur = cur.next;
        }
    }*/

    /**
     * 没有限制空间复杂度，就想简单一点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);

        ListNode s = smaller;
        ListNode b = bigger;

        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            }else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }

        s.next = bigger.next;
        b.next = null;
        return smaller.next;
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
