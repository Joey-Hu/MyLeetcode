package leetcode.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/10 16:25
 * @desc: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class M98_ValidateBinarySearchTree {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {

        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    /**
     * 中序遍历 + 判断
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraverse(root, res);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraverse(TreeNode root, List<Integer> inorder) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderTraverse(root.left, inorder);
        }
        inorder.add(root.val);
        if (root.right != null) {
            inorderTraverse(root.right, inorder);
        }
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
