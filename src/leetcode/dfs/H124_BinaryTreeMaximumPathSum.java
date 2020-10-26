package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/9/12 19:49
 * @desc: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class H124_BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        dfs(root, maxValue);
        return maxValue;
    }

    /**
     * 计算过当前结点的最大路径和
     * @param root
     * @return
     */
    private int dfs(TreeNode root, Integer maxValue) {
        // 如果节点为空的话，返回0
        if (root == null) {
            return 0;
        }

        // 过当前结点左子结点的最大路径和
        int left = dfs(root.left, maxValue);
        // 过当前结点右子结点的最大路径和
        int right = dfs(root.right, maxValue);

        //过当前结点的最大路径和
        int curSum = Math.max(root.val, Math.max(left + root.val, right + root.val));
        //如果将当前结点作为根结点，就要考虑横跨的情况
        int curMax = Math.max(curSum, left + right + root.val);
        //更新最大值
        maxValue = Math.max(maxValue, curMax);

        //返回过当前结点的最大路径和
        return curMax;
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
