package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/9/1 16:14
 * @desc: https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    /**
     * 把倒数 (k % length) 个节点移到前面来
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head==null||head.next==null) {
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++) {//Get the total length
            fast = fast.next;
        }

        for (int j=(i-k % i);j>0;j--) {//Get the i-n%i th node
            slow = slow.next;
        }

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur.next != null){
            cur = cur.next;
            prev = prev.next;
        }

        cur.next = head;
        prev.next = null;
        return cur;
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
