package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/9/1 21:50
 * @desc: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class M138_CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        Node iter = head;
        Node next;

        // 第一轮迭代，复制每一个节点并连接在该节点后面
        while (iter != null) {
            next = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // 第二轮循环：为每个copy节点安排随机节点
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // 第三轮: 提取复制节点
        iter = head;
        Node dummy = new Node(-1);
        Node copy, copyIter = dummy;

        while (iter != null) {
            next = iter.next.next;

            // 提取copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // 存储原始节点
            iter.next = next;
            iter = next;
        }

        return dummy.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
