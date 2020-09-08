package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/7 15:24
 * @desc: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {

    /**
     * 逐个合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }

        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }

        cur.next = (l1 == null) ? l2 : l1;
        return res.next;
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
