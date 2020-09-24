package leetcode.tree.binarysearchtree;

/**
 * @author: huhao
 * @time: 2020/9/10 16:25
 * @desc: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {

        if (root != null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
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
