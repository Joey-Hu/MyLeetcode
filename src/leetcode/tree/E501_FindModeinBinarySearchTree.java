package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/15 11:03
 * @desc: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class E501_FindModeinBinarySearchTree {

    TreeNode prev;
    private int count = 0;
    private int maxCount = -1;

    public int[] findMode(TreeNode root) {
        prev = root;
        List<Integer> modes = new ArrayList<>();
        inorder(root, modes);
        int[] ret = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            ret[i] = modes.get(i);
        }
        return ret;
    }

    private void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) {
            return;
        }
        inorder(root.left, modes);
        // update count
        count = root.val == prev.val ? count + 1 : 1;
        if (count > maxCount) {
            modes.clear();
            maxCount = count;
            modes.add(root.val);
        }else if (count == maxCount) {
            modes.add(root.val);
        }
        prev = root;
        inorder(root.right, modes);
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
