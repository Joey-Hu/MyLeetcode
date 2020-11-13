package leetcode.linkedlist;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/8 17:54
 * @desc: https://leetcode.com/problems/sort-list/
 */
public class M148_SortList {

    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;

        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }


    /**
         * 选择排序 TLE
         * 找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
         * 其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
         * 性能不理想 5% & 57%
         * @param head
         * @return
         */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode base = head;
        while (base != null && base.next != null) {
            ListNode cur = base;
            ListNode min = cur;
            // 找到最小值
            while (cur != null){
                if (cur.val < min.val) {
                    min = cur;
                }
                cur = cur.next;
            }
            // 交换值
            int temp = base.val;
            base.val = min.val;
            min.val = temp;

            base = base.next;
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
