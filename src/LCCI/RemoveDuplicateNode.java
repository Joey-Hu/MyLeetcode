package LCCI;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/7/1 21:45
 * @desc: https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class RemoveDuplicateNode {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 哈希，双指针 O(n)
        if (head == null) {
            return head;
        }

        Set<Integer> values = new HashSet<Integer>();
        ListNode prev = head;
        ListNode cur = head.next;
        values.add(prev.val);

        while(cur!=null){
            if(values.add(cur.val)){
                // 当指针所值节点的值不在set中，prev和cur都向后移动
                prev = cur;
                cur = cur.next;
            }else{
                // 当指针所值节点的值在set中，prev的next指向cur.next, 只有cur向后移动
                prev.next = cur.next;
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        // 不使用临时缓冲区 O(n^2)
        ListNode cur = head;

        while(cur != null){
            ListNode after = cur;
            while(after.next != null){
                if(cur.val == after.next.val){
                    after.next = after.next.next;
                }else{
                    after = after.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
