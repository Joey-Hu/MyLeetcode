package LCCI;

/**
 * @author: huhao
 * @time: 2020/7/26 13:35
 * @desc: https://leetcode-cn.com/problems/first-common-ancestor-lcci/
 */
public class FirstCommonAncestor {
    /**
     * 参考：https://leetcode-cn.com/problems/first-common-ancestor-lcci/solution/c-java-python-mian-shi-ti-0408-shou-ge-gong-tong-z/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left != null ? right != null ? root : left : right;
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
