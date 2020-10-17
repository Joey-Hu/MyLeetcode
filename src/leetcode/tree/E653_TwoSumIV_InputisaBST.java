package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/17 9:38
 * @desc: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class E653_TwoSumIV_InputisaBST {

    /**
     * 中序遍历 + 双指针
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int low = 0;
        int high = list.size()-1;
        while (low < high) {
            int sum = list.get(low) + list.get(high);
            if (sum == k) {
                return true;
            }else if (sum > k){
                high --;
            }else {
                low ++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
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
