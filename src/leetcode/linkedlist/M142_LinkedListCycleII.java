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
        ListNode slow = head;
        ListNode fast = head;
        // 结束条件：不存在环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 存在环
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }

        return null;
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
