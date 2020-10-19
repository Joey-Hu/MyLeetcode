package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/10/19 19:53
 * @desc: https://leetcode.com/problems/longest-palindrome/
 */
public class E409_LongestPalindrome {

    /**
     * hashSet统计出现奇数次数的数字个数
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {

        if (s.length() == 1) {
            return 1;
        }
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashSet.add(s.charAt(i))) {
                hashSet.remove(s.charAt(i));
            }
        }
        int odd = hashSet.size();
        return s.length() - (odd == 0 ? 0 : odd-1);
    }
}
