package leetcode;

/**
 * @author: huhao
 * @time: 2020/9/1 11:39
 * @desc: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesink_Group {
    /**
     * 每次倒置链表的 k 个结点
     * 第一次不会
     * 递归
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        int count = 0;
        // 找到第k+1个结点
        while (count < k) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
            count ++;
        }

        ListNode prev = reverseKGroup(cur, k);
        while (count > 0) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            count --;
        }
        return prev;
    }

    public class ListNode {
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
