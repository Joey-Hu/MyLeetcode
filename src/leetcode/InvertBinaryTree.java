package leetcode;

import sun.reflect.generics.tree.Tree;

import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/9/7 14:26
 * @desc: https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    /**
     * DFS 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.right;
        TreeNode right = root.left;
        root.left = invertTree(left);
        root.right = invertTree(right);
        return root;
    }

    /**
     * 迭代 BFS
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }

    private void swapValues(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }else if (p == null || q == null) {
            if (p == null) {
                 p = new TreeNode(q.val);
                 q = null;
            }else {
                q = new TreeNode(p.val);
                p = null;
            }
        }else {
            int temp = p.val;
            p.val = q.val;
            q.val = temp;
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
