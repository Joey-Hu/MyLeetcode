package leetcode.recursion;

/**
 * @author: huhao
 * @time: 2020/9/6 20:43
 * @desc: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    /**
     * 迭代方法
      * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(-1);
        ListNode cur3 = res;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur3.next = new ListNode(cur1.val);
                cur3 = cur3.next;
                cur1 = cur1.next;
            } else {
                cur3.next = new ListNode(cur2.val);
                cur3 = cur3.next;
                cur2 = cur2.next;
            }
        }
        cur3.next = (cur1 == null) ? cur2 : cur1;
        return res.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 终止条件
        if (l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode newHead = null;
        if(l1.val > l2.val){
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }else{
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        }

        return newHead;
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

