package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/23 10:42
 * @desc: https://leetcode.com/problems/longest-univalue-path/
 */
public class M687_LongestUnivaluePath {

    private int len = 0;
    public int longestUnivaluePath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        countNode(root, root.val);
        return len;
    }

    private int countNode(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int left = countNode(root.left, root.val);
        int right = countNode(root.right, root.val);

        len = Math.max(len, left+right);
        if (val == root.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
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
