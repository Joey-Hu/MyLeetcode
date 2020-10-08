package leetcode.linkedlist;

/**
 * @author: huhao
 * @time: 2020/10/8 14:05
 * @desc: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class M430_FlattenaMultilevelDoublyLinkedList {
    /**
     * one pass
     * 注意判断条件
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            // 如果没有子链表
            if (cur.child == null) {
                cur = cur.next;
//                continue;
            }

            // 如果有子链表
            Node child = cur.child;
            // 找到子链表的尾结点
            while (child.next != null) {
                child = child.next;
            }
            // 把尾结点连接到主链表上
            child.next = cur.next;
            // 完整双向链表
            if(cur.next != null) {
                cur.next.prev = child;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
