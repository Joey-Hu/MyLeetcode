package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/29 14:43
 * @desc: https://leetcode.com/problems/custom-sort-string/
 */
public class M791_CustomSortString {

    /**
     * Map
     * @param S
     * @param T
     * @return
     */
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();


        // 首先统计字符串T中各个字符的个数
        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }

        // 按照S中的字符顺序，逐个添加map中的字符，知道map.get(ch) == 0
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                while (map.get(S.charAt(i)) != 0) {
                    res.append(S.charAt(i));
                    map.put(S.charAt(i), map.get(S.charAt(i))-1);
                }
                map.remove(S.charAt(i));
            }
        }

        // 添加T中不存在于S中的字符
        for (Character character : map.keySet()) {
            while (map.get(character) != 0) {
                res.append(character);
                map.put(character, map.get(character)-1);
            }
        }

        return res.toString();
    }
}
