package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/10/15 9:37
 * @desc: https://leetcode.com/problems/sum-of-left-leaves/
 */
public class E404_SumofLeftLeaves {

    /**
     * recursive2
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }


    /**
     * recursive
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.left != null) {
            // root.left is a leaf
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }else { // root.left is not a leaf
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;
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
