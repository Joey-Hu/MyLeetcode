package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/10 9:04
 * @desc: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        return preOrder(res, root);

    }

    private List<Integer> preOrder(List<Integer> res, TreeNode root) {

        if (root != null) {
            res.add(root.val);

            if (root.left != null) {
                preOrder(res, root.left);
            }
            if (root.right != null) {
                preOrder(res, root.right);
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
