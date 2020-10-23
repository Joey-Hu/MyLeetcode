package leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/12 15:31
 * @desc: https://leetcode.com/problems/symmetric-tree/
 */
public class E101_SymmetricTree {

    /**
     * 递归 dfs
     * 类似 E100
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    /**
     * 迭代 stack
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);

        while (!stack.empty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
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
