package LCCI;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/7/7 16:27
 * @desc: https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 */
public class MinimumHeightTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        // * @param from the initial index of the range to be copied, inclusive
        // * @param to the final index of the range to be copied, exclusive.
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0, mid ));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1, nums.length));

        return root;

    }
}
