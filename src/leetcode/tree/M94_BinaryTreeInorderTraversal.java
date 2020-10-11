package leetcode.tree;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/9 21:02
 * @desc: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class M94_BinaryTreeInorderTraversal {

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
