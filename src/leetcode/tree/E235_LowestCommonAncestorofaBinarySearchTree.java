package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/13 20:53
 * @desc: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class E235_LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // p或q其中之一是root
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
