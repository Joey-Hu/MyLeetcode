package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/24 16:00
 * @desc: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class M1305_AllElementsinTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // traverse two lists using inorder traversal
        list1 = inorderTraverse(root1, list1);
        list2 = inorderTraverse(root2, list2);

        // merge two lists
        int index1 = 0;
        int index2 = 0;
        List<Integer> res = new ArrayList<>();
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                res.add(list1.get(index1));
                index1 ++;
            } else {
                res.add(list2.get(index2));
                index2 ++;
            }
        }

        while (index1 < list1.size()) {
            res.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            res.add(list2.get(index2++));
        }
        return res;
    }

    private List inorderTraverse(TreeNode root,  List res) {
        if (root != null) {
            if (root.left != null) {
                inorderTraverse(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inorderTraverse(root.right, res);
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
