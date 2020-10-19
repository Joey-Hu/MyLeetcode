package leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/19 20:26
 * @desc: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class M438_FindAllAnagramsinaString {

    /**
     * O(N^2logN)
     * 5% 17%
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        char[] charArray = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        Arrays.sort(charArray);
        String target = new String(charArray);

        for (int start = 0; start+len <= s.length(); start ++) {
            if (isAnagram(s.substring(start, start+len), target)) {
                res.add(start);
            }
        }
        return res;
    }

    private boolean isAnagram(String str, String target) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray).equals(target);
    }
}
