package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/9 10:32
 * @desc: https://leetcode.com/problems/palindrome-linked-list/
 */
public class E234_PalindromeLinkedList {

    /**
     * 逆转一半，然后逐个比较
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // find the middle node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 奇数节点
        if (fast != null) {
            slow = slow.next;
        }

        // 逆转后半部分节点
        slow = reverse(slow);
        fast = head;

        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /**
     * 整个链表倒转，然后逐个比较
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(head.val);
        ListNode newCur = newHead;
        while (cur != null) {
            newCur.next = new ListNode(cur.val);
            cur = cur.next;
            newCur = newCur.next;
        }

        ListNode reverse = reverse(newHead);
        cur = head;
        newCur = reverse;
        while (cur != null) {
            if (newCur.val != cur.val) {
                return false;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return true;
    }

    public ListNode reverse (ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
