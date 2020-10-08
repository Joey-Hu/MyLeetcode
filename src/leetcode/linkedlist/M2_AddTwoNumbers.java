package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/8/31 22:03
 * @desc: https://leetcode.com/problems/add-two-numbers/
 */
public class M2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode p, dummy = new ListNode(0);
        p = dummy;
        // 当 l1 指向结点 或者 l2 指向结点 不为空，且 carry 不等于零时，结果集还需要往后再加一个结点
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
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

    public static void main(String[] args) {

    }
}
