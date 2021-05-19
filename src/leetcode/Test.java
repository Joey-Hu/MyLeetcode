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

    private void allPop(char[] push, Stack<Character> stack, int begin,String out) {
        if (stack.empty() && begin == push.length) {
//            如果入栈完毕了，且也栈空了，就输出此出栈顺序，这个是递归的结束条件
            System.out.println(out);
        }else {
            Stack<Character> s1 = (Stack<Character>) stack.clone();
            Stack<Character> s2 = (Stack<Character>) stack.clone();

            // 选择入栈
            if (begin < push.length) {
                // 元素未全部入栈
                s1.push(push[begin]);
                allPop(push, s1, begin+1, out + "");

            }
            // 选择出栈
            if (!s2.empty()) {
                //如果栈不空，并且，入栈元素不是最后一个
                // 记录出栈元素
                String tmp = out + s2.pop();
//                s2.pop();
                allPop(push, s2, begin, tmp);

            }
        }
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
        char[] push = {'1', '2', '3'};
        test.allPop(push, new Stack<Character>(), 0, "");
//        System.out.println(res);


    }
}
