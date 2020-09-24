package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/9/24 17:13
 * @desc:
 */
public class M236_LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p, q exist below different subtrees
        if (left != null && right != null) {
            return root;
        }

        // p, q exist below same subtrees
        return left == null ? right : left;
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
