package LCCI;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/7/7 16:51
 * @desc: https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class ListOfDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 广度优先遍历 BFS
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> ret = new ArrayList<ListNode>();
        bfs(tree, ret);
        return ret.toArray(new ListNode[0]);
    }

    public void bfs(TreeNode tree, List<ListNode> ret){
        if (tree == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        int rear = queue.size();

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            rear--;
            cur.next = new ListNode(node.val);
            cur = cur.next;


            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            if(rear == 0){
                ret.add(head.next);
                cur = head;
                rear = queue.size();
            }
        }
    }
}
