package leetcode.linkedlist;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/8 14:52
 * @desc: https://leetcode.com/problems/add-two-numbers-ii/
 */
public class M445_AddTwoNumbersII {

    /**
     * stack + 头插法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 先将两个链表入栈
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            if (!stack1.empty()) {
                carry += stack1.pop();
            }
            if (!stack2.empty()) {
                carry += stack2.pop();
            }

            ListNode head = new ListNode(carry % 10);
            head.next = dummy.next;
            dummy.next = head;
            carry = carry / 10;
        }
        return dummy.next;
    }

    /**
     * stack
     * 效率不高 22% & 36%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> sum = new Stack<>();


        // 先将两个链表入栈
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            if (!stack1.empty()) {
                carry += stack1.pop();
            }
            if (!stack2.empty()) {
                carry += stack2.pop();
            }

            sum.push(carry%10);
            carry = carry / 10;
        }

        while (!sum.empty()) {
            cur.next = new ListNode(sum.pop());
            cur = cur.next;
        }
        return dummy.next;
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
