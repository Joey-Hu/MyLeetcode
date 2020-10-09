package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/9 15:31
 * @desc: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class M82_RemoveDuplicatesfromSortedListII {

    /**
     * 使用fake head在原链表上修改
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            // 找到等于cur.val的元素的最后一个
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // 如果该元素只有一个
            if (prev.next == cur) {
                prev = prev.next;
            }else {// 该元素有多个
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }

    /**
     * hashMap统计元素出现频率，找出频率为1的元素，新建链表
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // count the frequency of the elements
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }

        cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode newCur = dummy;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                newCur.next = new ListNode(cur.val);
                newCur = newCur.next;
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
