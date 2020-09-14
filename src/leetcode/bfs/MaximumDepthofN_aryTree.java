package leetcode.bfs;

import javax.sound.midi.Track;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/9/14 20:01
 * @desc: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthofN_aryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            maxDepth ++;
        }
        return maxDepth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
