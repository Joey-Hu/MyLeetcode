package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/9/12 19:49
 * @desc: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class H124_BinaryTreeMaximumPathSum {

    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return maxValue;
    }

    /**
     * 计算过当前结点的最大路径和
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        // 如果节点为空的话，返回0
        if (root == null) {
            return 0;
        }

        // 当前结点左子树的最大路径和
        int left = Math.max(dfs(root.left), 0);
        // 当前结点右子树的最大路径和
        int right = Math.max(dfs(root.right), 0);

        //更新最大值
        maxValue = Math.max(maxValue, root.val + left + right);

        //返回过当前结点的最大路径和，只能选择左右子树中的一条
        return Math.max(left, right) + root.val;
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
