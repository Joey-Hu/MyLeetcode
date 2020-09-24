package leetcode.tree;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: huhao
 * @time: 2020/9/24 16:47
 * @desc: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class H297_SerializeandDeserializeBinaryTree {

    private String spliter = ",";
    private String nullNode = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        return buildString(root, sb);
    }

    /**
     * traverse the tree using pre order traversal
     * @param root
     * @param sb
     * @return
     */
    private String buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullNode).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == "") {
            return null;
        }
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> data) {
        // Retrieves and removes the first element of this deque
        String val = data.remove();
        if (val.equals(nullNode)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(data);
            node.right = buildTree(data);
            return node;
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
