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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIdx = inMap.get(rootVal);
        int right = inEnd - rootIdx;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, rootIdx-1, postorder, postStart, postEnd-right - 1, inMap);
        root.right = buildTree(inorder, rootIdx+1, inEnd, postorder, postEnd-right, postEnd-1, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        new Main().buildTree(inorder, postorder);
    }


}


