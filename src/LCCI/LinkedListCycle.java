package LCCI;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/7/4 20:23
 * @desc: https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 */
public class LinkedListCycle {
    /**
     * 快慢指针寻找环入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        Set<ListNode> set = new HashSet<ListNode>();

        while(head != null){
            if(set.contains(head)){
                return head;
            }else{
                set.add(head);
            }
            head = head.next;
        }

        return null;


    }


        private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    }
