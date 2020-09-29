package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/29 10:51
 * @desc: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
public class M1525_NumberofGoodWaystoSplitaString {

    /**
     * Time Limit Exceeded
     * @param s
     * @return
     */
    public int numSplits(String s) {

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            int left = numOfUniqueLetters(s.substring(0, i));
            int right = numOfUniqueLetters(s.substring(i, s.length()));
            if (left == right) {
                res ++;
            }
        }
        return res;
    }

    private int numOfUniqueLetters(String str) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size();
    }

    public int numSplits2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        // 记录左半边字符串的单一字符
        Set<Character> set = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i-1);
            set.add(ch);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch)-1);
                }
                if (set.size() == map.size()) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "aaaaa";
        new M1525_NumberofGoodWaystoSplitaString().numSplits(s);
    }
}
