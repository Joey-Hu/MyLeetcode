package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/9 6:45
 * @desc: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class M1171_RemoveZeroSumConsecutiveNodesfromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        while (cur != null) {
            prefix += cur.val;
            if (map.containsKey(prefix)) {
                cur = map.get(prefix).next;
                int p = prefix + cur.val;
                // 删去map中要经过被删区域的prefix
                while (p != prefix) {
                    map.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                map.get(prefix).next = cur.next;
            }else {
                map.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;


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
