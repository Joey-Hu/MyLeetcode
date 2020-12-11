package leetcode.tree;

import java.util.Currency;

/**
 * @author: huhao
 * @time: 2020/12/11 15:49
 * @desc: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class M1448_CountGoodNodesinBinaryTree {

    /**
     * preorder遍历，找出遍历至今的当前最大curmax，和root.val比较，然后继续preorder
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        return helper(root, -100001);
    }

    private int helper(TreeNode root, int num) {

        if (root == null) {
            return 0;
        }
        int curMax = Math.max(root.val, num);
        return (root.val >= curMax ? 1 : 0) + helper(root.left, curMax) + helper(root.right, curMax);
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
