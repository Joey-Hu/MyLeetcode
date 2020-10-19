package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/19 21:33
 * @desc: https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class M451_SortCharactersByFrequency {

    /**
     * 桶排序
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] bucket = new ArrayList[s.length()+1];

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (Character key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length-1; pos >= 0; pos --) {
            if (bucket[pos] != null) {
                for (Character ch : bucket[pos]) {
                    for (int i = 0; i < pos; i++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}
