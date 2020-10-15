package leetcode.tree.binarysearchtree;

/**
 * @author: huhao
 * @time: 2020/9/24 11:32
 * @desc: https://leetcode.com/problems/same-tree/
 */
public class E100_SameTree {

    /**
     * 递归
     * 判断两棵树（p, q）是否相同：p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
