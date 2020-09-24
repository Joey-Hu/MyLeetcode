package leetcode.dfs;

import sun.reflect.generics.tree.Tree;

import java.util.Queue;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/22 7:02
 * @desc: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class M114_FlattenBinaryTreetoLinkedList {

    /**
     * dfs方法，最终还是转到后序遍历上来
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.empty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }

    private TreeNode prev = null;
    /**
     * 递归方法 + 后序遍历
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

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
