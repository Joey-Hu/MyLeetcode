package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/13 14:07
 * @desc: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class M116_PopulatingNextRightPointersinEachNode {

    /**
     * 双指针
     * 设计思路十分巧妙, 用两个指针 start 和 cur，其中 start 标记每一层的起始节点，cur 用来遍历该层的节点
     * @param root
     * @return
     */
    public Node connect2(Node root) {

        if (root == null) {
            return null;
        }

        Node start = root;
        Node cur = null;

        while (start.left != null) {
            cur = start;
            // 开始遍历该层
            while (cur != null) {
                // 如果当前结点的左子树非空，则该结点的左子树的next结点为该子树的右节点
                cur.left.next = cur.right;
                // 如果当前结点的next结点非空，则该结点的右子节点的next指向该结点的next结点的左子树
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                // 遍历该层下一个结点
                cur = cur.next;
            }
            // 遍历下一层
            start = start.left;
        }
        return root;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == size-1) {
                    cur.next = null;
                }else {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
