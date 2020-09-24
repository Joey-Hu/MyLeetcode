package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/9/24 17:29
 * @desc: https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class M222_CountCompleteTreeNodes {

    /**
     * 层级遍历 5%
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return count;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    /**
     *
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        int leftHeight = 1;
        int rightHeight = 1;
        TreeNode leftPath = root;
        TreeNode rightPath = root;

        while (leftPath != null) {
            leftHeight ++;
            leftPath = leftPath.left;
        }

        while (rightPath != null) {
            rightHeight ++;
            rightPath = rightPath.right;
        }

        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        } else {
            return 1 + countNodes3(root.left) + countNodes3(root.right);
        }
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

