package LCOF;

/**
 * @author: huhao
 * @time: 2020/10/28 21:57
 * @desc: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class LCOF26_subStructOfTree {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 与leetcode中的判例不同，当两棵树都为空时，不视作子结构
        if (A == null ||B == null) {
            return false;
        }

        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSame(TreeNode A, TreeNode B) {
        // 当B为空时，说明B已经访问完了，确定是A的子结构
        if (B == null) {
            return true;
        }
        //如果B不为空A为空，说明B不是A的子结构。
        if (A == null) {
            return false;
        }
        // 判断左右子结点
        return A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right);
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
