package leetcode.dynamicprogramming.houserobber;

import LCCI.FirstCommonAncestor;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: huhao
 * @time: 2020/9/16 13:41
 * @desc: https://leetcode.com/problems/house-robber-iii/
 */
public class M337_HouseRobberIII {


    /**
     * 每个结点都可以选择抢或者不抢，任何一个结点能偷到的最大钱的状态定义为:
     * 该结点选择不偷：该结点能偷到的最大钱 = 左孩子能偷到的最大钱 + 右孩子能偷到的最大钱
     * 该结点选择偷：该结点能偷到的最大钱 = 左孩子选择自己不偷时能偷到的最大钱 + 右孩子选择自己不偷时能偷到的最大钱 + 当前节点的钱数
     * 时间复杂度：O(N)
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {

        int[] res = robInternal(root);
        // 0 表示不偷，1 表示偷
        return Math.max(res[0], res[1]);
    }

    private int[] robInternal(TreeNode root) {

        // 递归结束
        if (root == null) {
            return new int[2];
        }

        // 递归执行左右子树
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }


    /**
     * dfs + hashMap
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = 0;
        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(root.val + val,  robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
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
