package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: huhao
 * @time: 2020/9/27 19:43
 * @desc: https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class M560_SubarraySumEqualsK {

    /**
     * 使用累计和 + hashMap
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // 初始化：用于统计从0到i的累计和等于k
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 当存在sum-k时，表示当前位置到map.get(sum-k)位置的和等与k
            if (map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }

    /**
     * 暴力方法
     * O(N^3)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                int sum = 0;
                for (int idx = i; k < j; k++) {
                    sum += nums[idx];
                }
                if (sum == k) {
                    res ++;
                }
            }
        }
        return res;
    }

    /**
     * 前缀和
     * 前缀和数组 preSum[i] = nums[0, ..., i-1]之和;如果想求nums[i, ..., j]之间的和，只需要求preSum[j+1] - preSum[i]
     * O(N^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {

        int[] preSum =new int[nums.length+1];
        preSum[0] = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    res ++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        new M560_SubarraySumEqualsK().subarraySum(arr, 3);
    }
}
