package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/19 14:10
 * @desc: https://leetcode.com/problems/isomorphic-strings/
 */
public class E205_IsomorphicStrings {

    /**
     * 构建 s和 t 对应的map，然后根据map构建字符串和 t 对比
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 构建s和t字符之间的唯一对应关系
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        StringBuilder newT = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            newT.append(map.get(s.charAt(i)));
        }

        return newT.toString().equals(t);
    }
}
