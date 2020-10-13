package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/13 15:33
 * @desc: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class M129_SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        int temp = 0;
        sum(root, temp, sum);
    }

    private void sum(TreeNode root, int temp, int sum) {
        if (root == null) {
            return;
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
