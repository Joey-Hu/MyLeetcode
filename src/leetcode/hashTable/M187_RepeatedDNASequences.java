package leetcode.hashTable;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/10/18 16:47
 * @desc: https://leetcode.com/problems/repeated-dna-sequences/
 */
public class M187_RepeatedDNASequences {

    /**
     * more elegant
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String cand = s.substring(i, i+10);
            if (!set.add(cand)) {
                res.add(cand);
            }
        }
        return new ArrayList(res);
    }


    /**
     * hashMap
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 9;
        while (end < s.length()) {
            String cand = s.substring(start, end+1);
            map.put(cand, map.getOrDefault(cand, 0)+1);
            start ++;
            end ++;
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                res.add(key);
            }
        }
        return res;
    }
}
