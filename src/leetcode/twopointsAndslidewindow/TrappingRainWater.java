package leetcode.twopointsAndslidewindow;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

/**
 * @author: huhao
 * @time: 2020/9/3 16:50
 * @desc: https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    /**
     * 双指针
     * 动画  https://leetcode.com/problems/trapping-rain-water/solution/
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height.length <= 1) {
            return 0;
        }

        int volume = 0;
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                }else {
                    volume += leftMax - height[left];
                }
                left ++;
            }else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                }else {
                    volume += rightMax - height[right];
                }
                right --;
            }
        }
        return volume;
    }
}
