package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/24 20:04
 * @desc: https://leetcode.com/problems/next-greater-element-i/
 */
public class E496_NextGreaterElementI {

    /**
     * 单调栈，注意题目有个条件：nums1中的元素是nums2的子集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i ++) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                // 记录每个元素（stack.pop()）的下一个最大值（nums2[i）
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
