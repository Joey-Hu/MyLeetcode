package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/8 15:24
 * @desc: https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class M725_SplitLinkedListinParts {

    /**
     * 有点绕
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }

        int width = len / k;
        int rem = len % k;
        cur = root;
        for (int i = 0; i < k; i++) {
            ListNode head = cur;
            // 条件值得注意
            for (int j = 0; j < width +(i < rem ? 1:0) - 1; j++) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            res[i] = head;
        }
        return res;

    }

    class ListNode {
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
}
