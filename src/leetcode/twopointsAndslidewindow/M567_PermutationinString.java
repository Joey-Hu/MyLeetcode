package leetcode.twopointsAndslidewindow;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author: huhao
 * @time: 2020/9/14 21:24
 * @desc: https://leetcode.com/problems/permutation-in-string/
 *
 */
public class M567_PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a'] ++;
        }

        int start = 0;
        int end = 0;
        int count = s1.length();

        while (end < s2.length()) {
            char c1 = s2.charAt(end);
            if (map[c1 - 'a'] > 0) {
                count --;
            }
            map[c1 - 'a'] --;
            end ++;
            while (count == 0) {
                if (end - start == s1.length()) {
                    return true;
                }else {
                    char c2 = s2.charAt(start);
                    map[c2 - 'a'] ++;
                    if (map[c2 - 'a'] > 0) {
                        count ++;
                    }
                    start ++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new M567_PermutationinString().checkInclusion("ab", "eidbaooo");
    }
}
