package LCCI;

/**
 * @author: huhao
 * @time: 2020/7/7 17:43
 * @desc: https://leetcode-cn.com/problems/check-balance-lcci/
 */
public class CheckBalance {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        checkBalance(root);
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public boolean checkBalance(TreeNode node){
        return Math.abs(cal_height(node.left) - cal_height(node.right)) > 1;
    }

    private int cal_height(TreeNode node) {
        if(node == null){
            return 0;
        }
        int i = cal_height(node.left);
        int j = cal_height(node.right);
        return (i>j) ? i+1:j+1;

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
