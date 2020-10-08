package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/8 20:57
 * @desc: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class E160_IntersectionofTwoLinkedLists {

    /**
     * 分别求解两个链表的长度，求得差值diff，再将较长的链表向后遍历diff个结点，然后一一比较即可
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int ALength = getLen(headA);
        int BLength = getLen(headB);

        ListNode curA = headA;
        ListNode curB = headB;

        while(ALength > BLength){
            curA = curA.next;
            ALength--;
        }

        while(ALength < BLength){
            curB = curB.next;
            BLength--;
        }

        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count ++;
        }
        return count;
    }

    /**
     * 利用环的思想
     * 参考: https://www.cnblogs.com/grandyang/p/4128461.html
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
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
