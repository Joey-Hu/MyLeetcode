package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/14 9:38
 * @desc: https://leetcode.com/problems/binary-tree-paths/
 */
public class E257_BinaryTreePaths {

    /**
     * 递归方法 +  StringBuilder
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return res;
        }
        getPaths2(root, res, sb);
        return res;
    }

    private void getPaths2 (TreeNode root, List<String> res, StringBuilder path) {

        if (root == null) {
            return;
        }
        int len = path.length();
        path.append(root.val);

        // 到达叶子节点
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        }else {   // 还未到达叶子节点
            path.append("->");
            getPaths2(root.left, res, path);
            getPaths2(root.right, res, path);
        }
        // 设置回原始长度
        path.setLength(len);

    }

    /**
     * 递归方法 + String
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        getPaths(root, res, "");
        return res;
    }

    private void getPaths(TreeNode root, List<String> res, String path) {
        if (root.left  == null && root.right == null) {
            res.add(path+root.val);
        }
        if (root.left != null) {
            getPaths(root.left, res, path+root.val+"->");
        }
        if (root.right != null) {
            getPaths(root.right, res, path+root.val+"->");
        }
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
