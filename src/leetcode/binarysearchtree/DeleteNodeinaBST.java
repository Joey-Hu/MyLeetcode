package leetcode.binarysearchtree;

import java.util.Random;

/**
 * @author: huhao
 * @time: 2020/9/11 12:55
 * @desc: https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeinaBST {

    /**
     * 首先先找到等于 key 的结点
     * 找到结点之后，分以下四种情况：
     *  1. 当该结点既没有左子树，有没有右子树的情况下，返回null;
     *  2. 当该节点只有左子树时，返回左子树；
     *  3. 当该节点只有右子树时，返回右子树；
     *  4. 当该节点既有左子树，又有右子树时，查找右子树的最小值，将该值设置为当前找到的结点，然后递归地删除右子树中的最小值
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int min = getMin(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }
        return root;
    }

    private Integer getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
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
