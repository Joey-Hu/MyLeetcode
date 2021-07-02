package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
import java.util.*;


public class Main {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = 0;
            height ++;
            for (int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return height;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};

        new Main().longestIncreasingPath(matrix);
    }


}


