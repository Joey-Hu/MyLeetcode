package leetcode.hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/20 16:08
 * @desc: https://leetcode.com/problems/set-mismatch/
 */
public class E645_SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[nums[i]] ++;
        }

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == 2) {
                res[0] = i+1;
            }
            if (copy[i] == 0) {
                res[1] = i+1;
            }
        }

        return res;
    }
}
