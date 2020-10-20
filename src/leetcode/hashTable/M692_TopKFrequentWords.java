package leetcode.hashTable;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/10/20 21:15
 * @desc: https://leetcode.com/problems/top-k-frequent-words/
 */
public class M692_TopKFrequentWords {

    /**
     * hashMap + bucket sort
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> stringFrequency = new HashMap<>();

        for (String word : words) {
            stringFrequency.put(word, stringFrequency.getOrDefault(word, 0)+1);
        }

        List<String>[] bucket = new ArrayList[words.length+1];

        for (String str : stringFrequency.keySet()) {
            int freq = stringFrequency.get(str);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<String>();
            }
            bucket[freq].add(str);
        }

        List<String> res1 = new ArrayList<>();
        for (int pos = bucket.length-1; pos >= 0 ; pos--) {
            if (bucket[pos] != null) {
                Collections.sort(bucket[pos]);
                res1.addAll(bucket[pos]);
            }
            if (res1.size() >= k) {
                break;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(res1.get(i));
        }
        return res;
    }
}
