package LCCI;

import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/10 19:14
 * @desc: https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class LegalBinarySearchTree {
    /**
     * 此题我们可以依靠二叉搜索树的特性：二叉搜索树的中序遍历序列为递增序列．
     * 用非递归方法实现中序遍历
     * 将树的左子树依次存入stack
     * 每次pop出一个TreeNode，判断其是否大于之前的数
     * 将其右子树的左子树也依次存入stack
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()){
            TreeNode temp = stack.pop();
            if(temp.val<=pre){
                return false;
            }
            pre = temp.val;
            if(temp.right!=null){
                TreeNode r = temp.right;
                while(r!=null){
                    stack.push(r);
                    r = r.left;
                }
            }
        }
        return true;
    }

    /**
     * 中序遍历+递归方法
     * @param root
     * @return
     */
    long pre;
    boolean fla
    public boolean isValidBST2(TreeNode root){

        if(root==null){
            return true;
        }


    }

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
