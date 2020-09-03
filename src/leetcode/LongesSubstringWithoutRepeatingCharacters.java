package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/3 13:48
 * @desc: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongesSubstringWithoutRepeatingCharacters {

    /**
     * slide window
     * 使用hashset检查字符是否在子串中
     * O (2N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j ++;
                ans = Math.max(ans, j-i);
            }else {
                // 存在相同字符，就把i向右移动，并删除 s[i]，直到不存在相同字符
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LongesSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
    }
}
