import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/6/20 17:26
 * @desc:
 */
public class BinaryTreePreorderTraversal144 {

    /**
     * recursive
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){

        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null){
            return ret;
        }
        ret.add(root.val);
        ret.addAll(preorderTraversal(root.left));
        ret.addAll(preorderTraversal(root.right));
        return ret;
    }

    /**
     * recursive with a helper
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root){

        ArrayList<Integer> ret = new ArrayList<Integer>();
        helper(root, ret);
        return ret;

    }

    public void helper(TreeNode root, ArrayList<Integer> ret){
        if(root==null){
            return;
        }
        ret.add(root.val);
        helper(root.left, ret);
        helper(root.right, ret);
    }

    /**
     * iterative(stack)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root){

        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null){
            return ret;

        }
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        toVisit.push(root);

        while(!toVisit.empty()){
            TreeNode isVisiting = toVisit.pop();
            if(isVisiting!=null){
                ret.add(isVisiting.val);
            }
            if(isVisiting.right!=null){
                toVisit.push(root.right);
            }
            if(isVisiting.left!=null){
                toVisit.push(root.left);
            }
        }

        return ret;
    }

    public static void main(String[] args) {

    }


}

class TreeNode{
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
