package LCCI;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/1 22:41
 * @desc: https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class KthNodeFromEndOfList {

    public int kthToLast(ListNode head, int k) {
        // 栈
        ListNode cur = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int value = 0;
        for(int i=0; i<k; i++){
            value = stack.pop();
        }
        return value;
    }

    public int kthToLast2(ListNode head, int k) {
        // 双指针
        ListNode p = head;
        ListNode q = head;

        // 先让q向后移动k，然后p,q一起向后移动，当q移动到null时，p指向的结点就是倒数第k个节点
        for(int i=0; i<k; i++){
            q = q.next;
        }

        while (q != null){
            p = p.next;
            q = q.next;
        }

        return p.val;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
