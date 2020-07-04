package LCCI;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/4 19:25
 * @desc: https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class PalindromeLinkedList {

    /**
     * 栈 O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<Integer>();

        ListNode cur = head;

        if(cur == null){
            return true;
        }

        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        cur = head;

        while(cur != null){
            if (cur.val != stack.peek()) {
                return false;
            }
            cur = cur.next;
            stack.pop();
        }
        return true;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {

        if(head == null){
            return true;
        }

        ListNode midNode = findMidNode(head);
        ListNode secondHalf = reverseLinked(midNode.next);

        return true;

    }

    /**
     * 翻转链表后半部分
     * @param next
     * @return
     */
    private ListNode reverseLinked(ListNode next) {
        ListNode front = next;
        return front;
    }

    /**
     * 寻找中间节点
     * @param head
     * @return
     */
    public ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
