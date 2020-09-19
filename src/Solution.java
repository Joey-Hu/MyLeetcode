import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {
        int[] nums = new int[]{5, 3, 8, 3, 2, 5};
        countBuildingds(nums);
    }

    public static  int[] countBuildingds(int[] nums) {
        // 能看到的楼的下标
        Stack<Integer> stack = new Stack<>();
        // 往左看能看到的楼的数量
        int[] leftLook = new int[nums.length];
        // 往右看能看到的楼的数量
        int[] rightLook = new int[nums.length];

        // 从右往左看
        for (int i = 0; i <= nums.length-1; i++) {
            leftLook[i] = stack.size();
            // 去掉被挡住的楼
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        stack.clear();

        // 从左往右看
        for (int i = nums.length-1; i >= 0; i--) {
            rightLook[i] = stack.size();
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        for(int i=0;i<=nums.length-1;i++) {
            leftLook[i] += 1 + rightLook[i];
        }
        return leftLook;
    }
}