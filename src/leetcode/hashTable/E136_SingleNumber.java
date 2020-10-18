package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/18 15:44
 * @desc: https://leetcode.com/problems/single-number/
 */
public class E136_SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequency.containsKey(nums[i])) {
                frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            }
        }

        for (Integer key : frequency.keySet()) {
            if (frequency.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
