package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/15 11:21
 * @desc: https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class M513_FindBottomLeftTreeValue {


    /**
     * BFS 从右往左
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }

    /**
     * 获得height，BFS遍历二叉树，到最后一层时输出最左边的结点
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {

        int height = getHeight(root);
        if (height == 0 || height == 1) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (count == height) {
                    res = cur.val;
                    break;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            count ++;

        }
        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return  1 + Math.max(getHeight(root.left), getHeight(root.right));
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
