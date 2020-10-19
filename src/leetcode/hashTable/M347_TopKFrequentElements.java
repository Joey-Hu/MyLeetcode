package leetcode.hashTable;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/9/6 16:05
 * @desc: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class M347_TopKFrequentElements {

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // bucket的下标表示频率
        List<Integer>[] bucket = new List[nums.length + 1];

        // 统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // 桶排序
        /*
        对 [5, 3, 5, 2, 8] 进行桶排序（从大到小）

        现有11个桶，编号 0 - 10，每出现一个数，就往对应编号的桶中放入一个球，然后从10到0，每次遇到不空的桶，就重复该桶中球数量次数的桶编号
        */
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >= 0 && res.size() < k; i --) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        int[] res2 = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }
}
