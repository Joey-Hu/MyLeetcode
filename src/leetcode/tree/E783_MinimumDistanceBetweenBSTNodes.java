package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/23 14:27
 * @desc: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class E783_MinimumDistanceBetweenBSTNodes {

    /**
     * inorder
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {

        int minDistance = Integer.MAX_VALUE;
        List<TreeNode> list = new ArrayList<>();
        inorderTraverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            minDistance = Math.min(minDistance, list.get(i).val - list.get(i-1).val);
        }
        return minDistance;
    }

    private void inorderTraverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        if(node.left != null) {
            inorderTraverse(node.left, list);
        }
        list.add(node);
        if(node.right != null) {
            inorderTraverse(node.right, list);
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
