package LCCI;

import java.beans.EventHandler;

/**
 * @author: huhao
 * @time: 2020/8/24 19:44
 * @desc: https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class VolumeOfHistogram {

    /**
     * 对于某一个柱体而言，它上面的水量等于它左右两边柱体最大值最小值的大小减去当前柱体的高度。
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        int[] v1 = new int[height.length];
        int[] v2 = new int[height.length];

        v1[0] = height[0];

        // 左边界
        for (int i=1; i<height.length; i++) {
            v1[i] = Math.max(v1[i-1], height[i]);
        }

        v2[height.length-1] = height[height.length-1];
        // 右边界
        for (int i=height.length-2; i>=0; i--) {
            v2[i] = Math.max(v2[i+1], height[i]);
        }

        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            volume += Math.min(v1[i], v2[i]) - height[i];
        }

        return volume;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new VolumeOfHistogram().trap(height));
    }
}
