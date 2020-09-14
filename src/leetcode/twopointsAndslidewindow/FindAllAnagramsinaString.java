package leetcode.twopointsAndslidewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/14 21:59
 * @desc: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a'] ++;
        }

        int start = 0;
        int end = 0;
        int count = p.length();

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1 - 'a'] > 0) {
                count --;
            }
            map[c1 - 'a'] --;
            end ++;
            while (count == 0) {
                if (end - start == p.length()) {
                    res.add(start);
                }
                char c2 = s.charAt(start);
                map[c2 - 'a'] ++;
                if (map[c2 - 'a'] > 0) {
                    count ++;
                }
                start ++;
            }
        }
        return res;
    }
}
