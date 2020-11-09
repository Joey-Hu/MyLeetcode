package leetcode.twopointsAndslidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/3 13:48
 * @desc: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class M3_LongesSubstringWithoutRepeatingCharacters {

    /**
     * slide window
     * 使用hashset检查字符是否在子串中
     * O (2N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int ans = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (set.add(s.charAt(end))) {
                end ++;
                ans = Math.max(ans, end - start);
            }else {
                // 存在相同字符，就把start向右移动，并删除 s[start]，直到不存在相同字符
                set.remove(s.charAt(start));
                start ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new M3_LongesSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
    }
}
