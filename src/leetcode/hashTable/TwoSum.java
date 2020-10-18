package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/31 20:48
 * @desc: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    /**
     * hashmap保存数据(key)和下标(index)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (!map.keySet().contains(nums[i])) {
                map.put(nums[i], i);
            }
            if (map.containsKey(component) && map.get(component) != i) {
                return new int[]{i, map.get(component)};
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
