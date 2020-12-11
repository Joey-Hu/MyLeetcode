package leetcode.tree;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/11 16:04
 * @desc: https://leetcode.com/problems/increasing-order-search-tree/
 */
public class E897_IncreasingOrderSearchTree {

    /**
     * 中序遍历，然后创建只有右子树的树
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode cur = newRoot;

        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return newRoot;
    }

    public void inorder(TreeNode root, List<Integer> list) {
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
