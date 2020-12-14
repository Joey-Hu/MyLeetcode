package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/3 14:38
 * @desc: https://leetcode.com/problems/container-with-most-water/
 */
public class M11_ContainerWithMostWater2 {

    /**
     * 双指针法 动画演示   https://leetcode.com/problems/container-with-most-water/solution/
     * O(N)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int volume = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            volume = Math.max(volume, Math.min(height[low], height[high]) * (high - low));

            // 如果我们每次移动较高的指针的话，这不会增加面积，因为面积取决于较矮的指针
            if (height[low] < height[high]) {
                low ++;
            }else {
                high --;
            }
        }
        return volume;
    }
}
