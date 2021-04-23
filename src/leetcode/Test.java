package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
public class Test {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.empty()) {
                stack.push(S.charAt(i));
            }

            if (S.charAt(i) == stack.peek()) {
                stack.pop();
            }else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();

    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 创建链表
//        ListNode raw = new ListNode(1);
//        ListNode cur = raw;
//        int[] val = new int[]{8, 3, 6, 5, 4, 7, 2};
//        for (int num : val) {
//            cur.next = new ListNode(num);
//            cur = cur.next;
//        }
//        cur.next = null;

        Test test = new Test();
        System.out.println(test.removeDuplicates("abbaca"));


    }
}
