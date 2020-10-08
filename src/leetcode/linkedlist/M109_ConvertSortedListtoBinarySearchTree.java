package leetcode.linkedlist;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/8 16:33
 * @desc: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class M109_ConvertSortedListtoBinarySearchTree {

    /**
     * 递归
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) {
            return null;
        }

        // 找到中间结点
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode thread = new TreeNode(slow.val);
        thread.left = toBST(head, slow);
        thread.right = toBST(slow.next, tail);
        return thread;
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
