package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/31 20:36
 * @desc: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class E387_FirstUniqueCharacterInAString {

    /**
     * 长度为26的数组存储每个字符出现的次数
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] array = new int[26];

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * hashmap 存储每个字符出现的次数
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.keySet().contains(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }
}
