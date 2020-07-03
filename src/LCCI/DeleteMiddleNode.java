package LCCI;

public class DeleteMiddleNode {

    public void deleteNode(ListNode node) {
//        https://leetcode-cn.com/problems/delete-middle-node-lcci/
        // 重点在于在循环结束时，cur指向最后一个非空节点，node指向cur的前一个节点
        ListNode cur = node.next;

        while(cur.next != null){
            node.val = cur.val;
            node = cur;
            cur = cur.next;
        }
        node.val = cur.val;
        node.next = cur.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
