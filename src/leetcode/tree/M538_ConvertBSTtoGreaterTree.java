package leetcode.tree;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/10/15 16:07
 * @desc: https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class M538_ConvertBSTtoGreaterTree {

    /**
     * reverse inorder traverse
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        helper(root, sum);
        return root;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int right = helper(root.right, sum);
        root.val += right;
        int left = helper(root.left, root.val);
        return left;
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
