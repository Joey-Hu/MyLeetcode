package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/9 21:02
 * @desc: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        return inorder(res, root);
    }

    public List<Integer> inorder(List<Integer> res, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorder(res,  root.left);
            }
            res.add(root.val);
            if (root.right != null) {
                inorder(res,  root.right);
            }
        }
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
