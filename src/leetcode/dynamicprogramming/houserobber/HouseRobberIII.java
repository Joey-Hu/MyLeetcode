package leetcode.dynamicprogramming.houserobber;

import LCCI.FirstCommonAncestor;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: huhao
 * @time: 2020/9/16 13:41
 * @desc: https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {

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
