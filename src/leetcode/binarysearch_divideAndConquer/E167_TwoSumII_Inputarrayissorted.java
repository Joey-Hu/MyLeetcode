package leetcode.binarysearch_divideAndConquer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/10 10:41
 * @desc: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class E167_TwoSumII_Inputarrayissorted {

    /**
     * 双指针
     * 时间复杂度 O(N)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int[] res = {-1, -1};

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                res[0] = low + 1;
                res[1] = high + 1;
            }else if (numbers[low] + numbers[high] > target) {
                high --;
            }else {
                low ++;
            }
        }
        return res;
    }
}
