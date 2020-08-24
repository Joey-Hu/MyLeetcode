package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/24 15:55
 * @desc: https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class FindMajorityElement2 {
    /**
     * 摩尔投票算法
     * 时间复杂度 O（N） 空间复杂度 O (1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int major = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != major) {
                count -- ;
            } else {
                count ++;
            }
            if (count == 0){
                major = nums[i];
                count = 1;
            }
        }
        int halfTimes = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == major) {
                count ++;
            }
            if (count == halfTimes) {
                return major;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        FindMajorityElement2 findMajorityElement = new FindMajorityElement2();
        findMajorityElement.majorityElement(nums);
    }
}
