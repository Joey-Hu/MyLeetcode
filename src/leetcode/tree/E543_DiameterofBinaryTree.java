package leetcode.tree;

import java.awt.print.PrinterAbortException;

/**
 * @author: huhao
 * @time: 2020/10/15 19:32
 * @desc: https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class E543_DiameterofBinaryTree {

    /**
     * 对于每个结点，最长路径 = 左子树的最大深度 + 右子树的最大深度
     * @param root
     * @return
     */
    int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxLen;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxLen = Math.max(maxLen, left + right);

        return Math.max(left, right) + 1;
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
