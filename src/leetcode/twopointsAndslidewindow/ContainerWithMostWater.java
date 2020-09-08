package leetcode.twopointsAndslidewindow;

import java.time.temporal.ValueRange;

/**
 * @author: huhao
 * @time: 2020/9/3 14:38
 * @desc: https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int volume = 0;

        for (int i = 0; i<height.length-1; i++) {
            for (int j = i+1; j<height.length; j++) {
                volume = Math.max(volume, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return volume;
    }
}
