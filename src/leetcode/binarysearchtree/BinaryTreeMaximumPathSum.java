package leetcode.binarysearchtree;

/**
 * @author: huhao
 * @time: 2020/9/12 19:49
 * @desc: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    private int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        dfs(root);
        return maxValue;
    }

    /**
     * 以root为顶点的所有直上直下的path中path sum最大的一条的值
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        // 如果节点为空的话，返回0
        if (root == null) {
            return 0;
        }

        // 假设递归到节点n，首先计算左子树的最大路径和left，并与0进行比较，若left<0，则left=0；右子树同理
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 更新全局最大值结果 maxValue，就是以左子结点为终点的最大 path 之和加上以右子结点为终点的最大 path 之和，
        // 还要加上当前结点值，这样就组成了一个条完整的路径。
        maxValue = Math.max(maxValue, root.val + left + right);
        // 返回值是取 left 和 right 中的较大值加上当前结点值，因为返回值的定义是以当前结点为终点的 path 之和，
        // 所以只能取 left 和 right 中较大的那个值，而不是两个都要
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
