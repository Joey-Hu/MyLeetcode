package leetcode.tree;

import LCCI.RotateImage;

/**
 * @author: huhao
 * @time: 2020/10/15 19:52
 * @desc: https://leetcode.com/problems/subtree-of-another-tree/
 */
public class E572_SubtreeofAnotherTree {

    /**
     * 与E100类似
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
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
