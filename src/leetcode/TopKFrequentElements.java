package leetcode;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/9/6 16:05
 * @desc: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        // 统计频率
        for (int num : nums) {
            if (!map.keySet().contains(num)) {
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            int frequence = map.get(key);
            if (bucket[frequence] == null) {
                bucket[frequence] = new ArrayList<>();
            }
            bucket[frequence].add(key);
        }

        int[] res = new int[k];
        for (int pos = bucket.length-1; pos >=0 && res.length < k; pos --) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
