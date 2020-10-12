package leetcode.tree;


import java.util.*;

/**
 * @author: huhao
 * @time: 2020/10/12 16:26
 * @desc: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class M103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isReverse = false;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (!isReverse) {
                    temp.add(cur.val);
                }else {
                    temp.add(0, cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(temp);
            isReverse = !isReverse;
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
