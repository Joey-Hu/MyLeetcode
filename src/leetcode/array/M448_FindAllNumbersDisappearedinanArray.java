package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/25 15:34
 * @desc: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class M448_FindAllNumbersDisappearedinanArray {

    /**
     * 对于每个数字 nums[i]，如果nums[nums[i]-1] 是正数，就赋值为相反数，如果已经是负数了，就不变；
     * 最后我们只要把留下的整数对应的位置加入结果res中即可
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] = -nums[j];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    /**
     * 用数组表示频次
     * O(N) O(N)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] array = new int[nums.length];
        List<Integer> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            array[nums[i]-1] ++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
