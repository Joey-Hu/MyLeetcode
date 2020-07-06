package LCCI;

public class SumLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        https://leetcode-cn.com/problems/sum-lists-lcci/
        // 1. 将链表转化为long类型，相加，再转为链表
        // 2. 遍历链表
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int carry = 0;

        while(l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int num = num1 + num2 + carry;
            carry = num / 10;

            cur.next = new ListNode(num % 10);

            l1 = l1.next == null ? null : l1.next;
            l2 = l2.next == null ? null : l2.next;
            cur = cur.next;
        }

        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return ans.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
