package leetcode.tree.binarysearchtree;

/**
 * @author: huhao
 * @time: 2020/9/11 13:19
 * @desc: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertintoaBinarySearchTree2 {

    /**
     * 迭代方法
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (val <= cur.val) {
                if (cur.left != null) {
                    cur = cur.left;
                }else {
                    cur.left = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
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
