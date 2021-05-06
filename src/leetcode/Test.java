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

    public int trap(int[] height) {
        // 左右指针
        int left = 0;
        int right = height.length - 1;
        // 记录左右最大高度
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;

        while (left < right) {
            // 用于移动指针，if成立，移动左指针，否则，移动右指针
            if (height[left] <  height[right]) {
                // 更新最大值
                maxLeft = Math.max(height[left], maxLeft);
                // 获取雨水
                res += maxLeft - height[left];
                left ++;
            }else {
                maxRight = Math.max(height[right], maxRight);
                res += maxRight - height[right];
                right --;
            }
        }
        return res;
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
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test.trap(height));


    }
}
