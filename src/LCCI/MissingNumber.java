package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/24 19:25
 * @desc: https://leetcode-cn.com/problems/missing-number-lcci/
 */
public class MissingNumber {
    /**
     * 1. 排序
     * 2. 数组标记
     * 3. 先高斯求和，再逐个减去num
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int[] array = new int[nums.length + 1];

        for (int i=0; i<nums.length; i++) {
            array[nums[i]] = 1;
        }

        for (int i=0; i<array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {

        int sum = (0+nums.length) * (nums.length+1) / 2;

        for (int i=0; i<nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
