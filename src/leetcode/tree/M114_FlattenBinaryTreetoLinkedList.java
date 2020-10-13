package leetcode.tree;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/13 13:59
 * @desc: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class M114_FlattenBinaryTreetoLinkedList {

    /**
     * stack + dfs
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
