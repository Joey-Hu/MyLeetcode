package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/12 21:22
 * @desc: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class E108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = buildBST(nums, 0, nums.length-1);
        return root;

    }

    private TreeNode buildBST(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid-1);
        root.right = buildBST(nums, mid+1, end);

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
