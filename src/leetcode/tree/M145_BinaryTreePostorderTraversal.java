package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/10 9:19
 * @desc: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class M145_BinaryTreePostorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;

    }

    private void postOrder(List<Integer> res, TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrder(res, root.left);
        }
        if (root.right != null) {
            postOrder(res, root.right);
        }
        res.add(root.val);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }

        pushAllLeft(root, stack);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            pushAllLeft(root.right, stack);
            res.add(cur.val);
        }
        return res;
    }

    private void pushAllLeft(TreeNode root, Stack stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
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
