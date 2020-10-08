package leetcode.linkedlist;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/8 17:54
 * @desc: https://leetcode.com/problems/sort-list/
 */
public class M148_SortList {

    /**
     * 选择排序
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
