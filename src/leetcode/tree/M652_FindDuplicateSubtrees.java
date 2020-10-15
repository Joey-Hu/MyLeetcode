package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/15 21:25
 * @desc: https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class M652_FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

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
