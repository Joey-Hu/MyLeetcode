package leetcode.twopointsAndslidewindow;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

/**
 * @author: huhao
 * @time: 2020/9/3 16:50
 * @desc: https://leetcode.com/problems/trapping-rain-water/
 */
public class H42_TrappingRainWater {
    /**
     * 双指针
     * 动画  https://leetcode.com/problems/trapping-rain-water/solution/
     * @param height
     * @return
     */
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
}
