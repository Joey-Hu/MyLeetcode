package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/19 15:18
 * @desc: https://leetcode.com/problems/word-pattern/
 */
public class E290_WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i ++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(words[i])) {
                map.put(pattern.charAt(i), words[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (i != pattern.length() - 1) {
                sb.append(map.get(pattern.charAt(i))).append(" ");
            }else {
                sb.append(map.get(pattern.charAt(i)));
            }
        }
        return sb.toString().equals(s);
    }
}
