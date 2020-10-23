package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/9/10 16:09
 * @desc: https://leetcode.com/problems/balanced-binary-tree/
 */
public class E110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced
                (root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
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
