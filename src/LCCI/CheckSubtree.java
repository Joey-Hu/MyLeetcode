package LCCI;

/**
 * @author: huhao
 * @time: 2020/7/29 16:06
 * @desc: https://leetcode-cn.com/problems/check-subtree-lcci/
 */
public class CheckSubtree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        /**
         * 遍历t1的每个节点，判断以t1中的每个节点为根的子树是否与t2相同
         */
        if(t1 == null){
            return t2 == null;
        }

        return sameSubTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);


    }

    private boolean sameSubTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }

        return t1.val == t2.val && sameSubTree(t1.left, t2.left) && sameSubTree(t1.right, t2.right);
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
