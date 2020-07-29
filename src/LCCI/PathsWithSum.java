package LCCI;

/**
 * @author: huhao
 * @time: 2020/7/29 16:25
 * @desc:
 */
public class PathsWithSum {
    public int pathSum(TreeNode root, int sum) {
        /**
         * 从根节点开始，递归遍历树的每一个节点n，从n出发，向下遍历
         * 注意求解路劲和时，终止条件不能为当前结点的值等于目标值，因为一条路径中可能存在多组解。
         * 例如[1,3,-1,1]这条路径中如果目标sum是4的话，意味着[1,3,-1,1]和[1,3]都是解，当遍历到3的时候虽然有解，但不能直接退出。
         */
        if(root == null){
            return 0;
        }
        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int path(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val == sum){
            res ++;
        }
        res += path(root.left, sum - root.val);
        res += path(root.right, sum - root.val);
        return res;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
