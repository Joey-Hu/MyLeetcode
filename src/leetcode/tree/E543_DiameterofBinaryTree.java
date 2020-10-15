package leetcode.tree;

import java.awt.print.PrinterAbortException;

/**
 * @author: huhao
 * @time: 2020/10/15 19:32
 * @desc: https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class E543_DiameterofBinaryTree {

    /**
     * 最长路径有两种情况：
     * 1. 经过根节点，找出根节点左右两棵子树的最大深度相加即可
     * 2. 不经过根节点，只需要找出根节点的左子树或者根节点的右子树作为根的最长路径度即可
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 经过根结点
        int dia = height(root.left) + height(root.right);
        // 不经过根结点
        int lia = diameterOfBinaryTree(root.left);
        int ria = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(lia, ria));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
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
