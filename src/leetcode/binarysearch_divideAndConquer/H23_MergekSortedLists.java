package leetcode.binarysearch_divideAndConquer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: huhao
 * @time: 2020/9/7 15:24
 * @desc: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class H23_MergekSortedLists {

    /**
     * 最小堆
     * 建立一个大小为 lists.size() 的最小堆，首先先将所有链表的的首节点加入到最小堆中，然后从最小堆中获取最小首节点（堆顶元素）minListNode
     * 加入到结果链表中，如果 minListNode 有后继节点，将后继节点加入到最小堆中，自动排序，重复上述过程
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;

        ListNode res = new ListNode(-1);
        ListNode cur = res;

        if (len == 0 || lists == null) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(len, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode minListNode = minHeap.poll();
            cur.next = minListNode;
            cur = cur.next;

            if (minListNode.next != null) {
                minHeap.offer(minListNode.next);
            }
        }
        return res.next;
    }

    /**
     * 逐个合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }

        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }

        cur.next = (l1 == null) ? l2 : l1;
        return res.next;
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
