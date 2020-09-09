package leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/9 21:02
 * @desc: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal2 {

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushAllLeft(root, stack);

        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushAllLeft(root.right, stack);
        }
        return res;
    }

    public void pushAllLeft(TreeNode root, Stack stack) {
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
