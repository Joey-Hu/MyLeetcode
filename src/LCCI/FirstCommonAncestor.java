package LCCI;

/**
 * @author: huhao
 * @time: 2020/7/26 13:35
 * @desc: https://leetcode-cn.com/problems/first-common-ancestor-lcci/
 */
public class FirstCommonAncestor {
    /**
     * 参考：https://leetcode-cn.com/problems/first-common-ancestor-lcci/solution/c-java-python-mian-shi-ti-0408-shou-ge-gong-tong-z/
     *（1）如果p 、q中有一个是根节点，那么它本身就是首个共同祖先；
     * （2）如果p、q分别在根节点的左右子树中，那么它本身也是首个共同祖先；
     * （3）如果p、q都同在根节点的左子树或右子树中，那就用递归的方法，将左子节点或右子节点作为根节点求解。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        // 满足条件1
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果left和right都不为空，说明p, q分别在左右子树上，满足条件2
        if(left!=null && right!=null){
            return root;
        }
        //如果左子树为空，说明p、q都在右子树中，将右子节点作为根节点，满足(3)
        if(left == null){
            return right;
        }

        //如果右子树为空，说明p、q都在左子树中，将左子节点作为根节点，满足(3)
        if(right == null){
            return left;
        }
        //如果左右子树都为空，说明p、q都不存在，本题不会出现这种情况
        return null;
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
