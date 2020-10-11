package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/11 21:19
 * @desc: https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class M95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();



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
