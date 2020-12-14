package leetcode.array;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/12 11:10
 * @desc: https://leetcode.com/problems/number-of-good-pairs/
 */
public class E1512_NumberofGoodPairs {

    /**
     * 方法很有趣
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 假设是[1, 1, 1]，res = 3 = 1 + 2
            if (nums[i] == nums[index]) {
                res += i - index;
            }else {
                index = i;
            }
        }
        return res;
    }
}
