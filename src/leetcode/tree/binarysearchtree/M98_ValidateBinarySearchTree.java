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
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {

        if (root != null) {
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

        if (root == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
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
