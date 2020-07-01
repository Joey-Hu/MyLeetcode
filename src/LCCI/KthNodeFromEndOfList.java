package LCCI;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/1 22:41
 * @desc:
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

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
