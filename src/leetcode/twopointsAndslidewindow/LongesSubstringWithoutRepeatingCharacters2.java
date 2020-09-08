package leetcode.twopointsAndslidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/3 13:48
 * @desc: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongesSubstringWithoutRepeatingCharacters2 {

    /**
     * slide window
     * 使用hashmap检查字符是否在子串中
     * O (N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LongesSubstringWithoutRepeatingCharacters2().lengthOfLongestSubstring("pwwkew");
    }
}
