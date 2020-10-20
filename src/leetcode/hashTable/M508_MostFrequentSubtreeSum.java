package leetcode.hashTable;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/10/20 9:23
 * @desc: https://leetcode.com/problems/most-frequent-subtree-sum/
 */
public class M508_MostFrequentSubtreeSum {

    /**
     * 后序遍历
     * ref : https://www.cnblogs.com/grandyang/p/6481682.html
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        postorder(root, sumFrequency, count);
        for (Integer key : sumFrequency.keySet()) {
            if (sumFrequency.get(key) == count) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 通过后序遍历获得以root为根的子树和, 使用变量 count 记录出现的最高频率
     * @param root
     * @param map
     * @param count
     * @return
     */
    private int postorder(TreeNode root, Map<Integer, Integer> map, int count) {
        if (root == null) {
            return 0;
        }
        int left = postorder(root.left, map, count);
        int right = postorder(root.right, map, count);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        count = Math.max(count, map.get(sum));
        return sum;
    }

    /**
     * 统计以树中各节点作为根节点的书的子树总和，使用 map 和变量 count 统计 sum 的频率
     * 效率差，7% 6%
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> sumFrequency = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int sum = getSubtreeSum(cur);
                sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0)+1);
                if (sumFrequency.get(sum) >= count) {
                    if (sumFrequency.get(sum) > count) {
                        list.clear();
                    }
                    list.add(sum);
                    count = sumFrequency.get(sum);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int getSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getSubtreeSum(root.left) + getSubtreeSum(root.right);
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
