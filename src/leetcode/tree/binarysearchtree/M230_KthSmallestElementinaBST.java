package leetcode.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/30 17:03
 * @desc: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class M230_KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> inorder = new ArrayList<>();
        inorderTraverse(inorder, root);

        return inorder.get(k-1);
    }

    private void inorderTraverse(List<Integer> inorder, TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(inorder, root.left);
        inorder.add(root.val);
        inorderTraverse(inorder, root.right);
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
