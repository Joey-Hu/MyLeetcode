package leetcode.twopointsAndslidewindow;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/12/11 16:19
 * @desc: https://leetcode.com/problems/valid-triangle-number/
 */
public class M611_ValidTriangleNumber {

    /**
     * O(N^2)
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int res = 0;
        for (int r = nums.length-1; r >= 2; r--) {
            int l = 0;
            int m = r-1;
            while (l < m) {
                if (nums[l] + nums[m] > nums[r]) {
                    res += m-l;
                    m --;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
