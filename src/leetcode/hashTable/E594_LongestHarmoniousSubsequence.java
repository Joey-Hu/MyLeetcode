package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/20 15:30
 * @desc: https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class E594_LongestHarmoniousSubsequence {

    /**
     * hashMap
     * 使用 map 记录每个数字出现的次数，然后遍历 map.keyset(), 对于每个 key 判断 key+1 是否存在;
     * 如果存在，map.get(key)+map.get(key+1)，取最大值即可
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength= 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Integer key : map.keySet()) {
            if (map.containsKey(key+1)) {
                maxLength = Math.max(maxLength, map.get(key)+map.get(key+1));
            }
        }
        return maxLength;
    }
}
