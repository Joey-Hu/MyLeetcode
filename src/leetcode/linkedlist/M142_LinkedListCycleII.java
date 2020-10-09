package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/9 14:18
 * @desc: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class M142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;

        // 判断是否存在环
        // 注意终止条件
        while (fast != null && slow != null) {
            fast = fast.next.next;
            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
