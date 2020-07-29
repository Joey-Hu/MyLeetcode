package LCCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/7/29 15:42
 * @desc: https://leetcode-cn.com/problems/bst-sequences-lcci/
 */
public class BSTSequences {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    Queue<TreeNode> q = new LinkedList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        /**
         * 双端链表 + 回溯
         */
        if (root == null){
            return ans;
        }
        q.add(root);
        dfs();
        return ans;
    }

    private void dfs() {
        if (q.isEmpty()){
            ans.add(temp);
            return;
        }
        int size = q.size();
        while(size-- != 0){
            TreeNode tp = q.poll();

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
