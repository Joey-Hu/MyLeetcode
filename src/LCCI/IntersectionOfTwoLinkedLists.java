package LCCI;

import java.util.ArrayList;

/**
 * @author: huhao
 * @time: 2020/7/4 20:04
 * @desc: https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(headA != null){
            arrayList.add(headA.val);
            headA = headA.next;
        }

        while (headB != null){
            if(arrayList.contains(headB.val)){
                return headB;
            }
            headB = headB.next;
        }
        return null;



    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }
}
