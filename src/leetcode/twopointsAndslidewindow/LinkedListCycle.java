package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 19:56
 * @desc: https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
