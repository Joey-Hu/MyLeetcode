package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/9/24 9:43
 * @desc: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class M116_PopulatingNextRightPointersinEachNode {

    /**
     * BFS方法
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
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (i == size - 1) {
                    cur.next = null;
                }else {
                    cur.next = queue.peek();
                }
            }
        }
        return root;
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null){
            return null;

        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
