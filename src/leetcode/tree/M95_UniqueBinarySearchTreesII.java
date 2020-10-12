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

        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        List<TreeNode> left;
        List<TreeNode> right;

        for(int i=start;i<=end;i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            for (TreeNode lTreeNode : left) {
                for (TreeNode rTreeNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lTreeNode;
                    root.right = rTreeNode;
                    res.add(root);
                }
            }
        }
        return res;
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
