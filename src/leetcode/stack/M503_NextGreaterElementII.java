package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/24 19:30
 * @desc: https://leetcode.com/problems/next-greater-element-ii/
 */
public class M503_NextGreaterElementII {

    /**
     * 单调栈
     * @param nums
     * @return
     * reference: https://blog.csdn.net/weixin_42784951/article/details/88963758
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 从后面开始遍历，即从右往左看
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            // 比大小，栈内元素弹出直到栈顶元素大于nums[i]
            while (!stack.empty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            // 如果栈为空，表示后面没有元素比其大
            res[i % nums.length] = stack.empty() ? -1 : stack.peek();
            // 将元素放进去比大小
            stack.push(nums[i % nums.length]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        new M503_NextGreaterElementII().nextGreaterElements(nums);
    }
}
