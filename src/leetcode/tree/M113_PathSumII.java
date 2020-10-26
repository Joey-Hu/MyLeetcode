package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/13 10:49
 * @desc: https://leetcode.com/problems/path-sum-ii/
 */
public class M113_PathSumII {

    /**
     * 每当DFS搜索到新结点时，保存该节点，每当找到一条路径时，保存该路径，如果 搜索到叶子节点，发现不是路径时，返回上一节点
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSum(root, sum, temp, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        // 终止条件1
        if (root == null) {
            return;
        }

        temp.add(new Integer(root.val));
        // 终止条件2
        if (root.left == null && root.right == null && sum-root.val==0) {
            // 添加的是引用
            // res.add(temp);
            res.add(new ArrayList<>(temp));
        }
        pathSum(root.left, sum-root.val, temp, res);
        pathSum(root.right, sum-root.val, temp, res);

        temp.remove(temp.size()-1);
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
