package LCCI;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/24 14:09
 * @desc: https://leetcode-cn.com/problems/successor-lcci/
 */
public class successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> treeNodeArray = new ArrayList<TreeNode>();
        inorder(root, treeNodeArray);
        treeNodeArray.add(null);
        for(int i=0; i<treeNodeArray.size(); i++){
            if(treeNodeArray.get(i) == p){
                return treeNodeArray.get(i+1);
            }
        }
        return null;
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> ta){
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.empty()){
            TreeNode temp = stack.pop();
            ta.add(temp);
            if(temp.right!=null){
                TreeNode r = temp.right;
                while(r!=null){
                    stack.push(r);
                    r = r.left;
                }
            }
        }
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
