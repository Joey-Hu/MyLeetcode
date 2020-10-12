package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/12 21:06
 * @desc: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class M106_ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * 与M105类似
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTree(postorder, postStart, postStart + numLeft - 1, inorder, inStart, inRoot-1, map);
        root.right = buildTree(postorder, postStart+numLeft, postEnd-1, inorder, inRoot+1, inEnd, map);

        return root;
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
