package leetcode.sort;

import LCCI.SumLists;

/**
 * @author: huhao
 * @time: 2020/10/21 13:58
 * @desc: https://leetcode.com/problems/insertion-sort-list/
 */
public class M147_InsertionSortList {

    /**
     * 从原链表中逐个取出元素，在新链表中找到合适的位置插入
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head != null) {
            ListNode temp = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = temp;
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
