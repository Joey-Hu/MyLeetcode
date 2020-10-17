package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/17 10:08
 * @desc: https://leetcode.com/problems/maximum-binary-tree/
 */
public class M654_MaximumBinaryTree {

    /**
     * 递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private int getIndexOfMax(int[] nums, int start, int end) {
        int max = nums[start];
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    private TreeNode buildTree (int[] nums, int start, int end) {
        if (start > end && start >= 0 && end <= nums.length-1) {
            return null;
        }
        int idxOfMaxnum = getIndexOfMax(nums, start, end);
        TreeNode root = new TreeNode(nums[idxOfMaxnum]);
        root.left = buildTree(nums, start,idxOfMaxnum-1);
        root.right = buildTree(nums, idxOfMaxnum+1, end);
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
