package leetcode.tree;

import com.sun.org.apache.regexp.internal.REUtil;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/13 15:33
 * @desc: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class M129_SumRoottoLeafNumbers {

    /**
     * 递归
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return sum(root.left, sum*10+root.val) + sum(root.right, sum*10+root.val);
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
