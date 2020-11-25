package leetcode.sort;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/23 9:38
 * @desc:
 */
public class M767_ReorganizeString {

    /**
     * Consider this example: "aaabbbcdd", we will construct the string in this way:

     a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
     a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
     a b a c a _ b _ b // fill in "c" at position 3
     a b a c a d b d b // fill in "d" at position 5, 7

     * @param S
     * @return
     */
    public String reorganizeString(String S) {

        int[] charFreq = new int[26];
        for (int i = 0; i < S.length(); i ++) {
            charFreq[S.charAt(i)-'a']++;
        }

        int max = 0;
        int letter = 0;
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > max) {
                max = charFreq[i];
                letter = i;
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        int idx = 0;
        char[] res = new char[S.length()];

        while (charFreq[letter] > 0) {
            res[idx] = (char)(letter + 'a');
            idx = idx + 2;
            charFreq[letter] --;
        }
        for (int i = 0; i < charFreq.length; i++) {
            while (charFreq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                idx = idx + 2;
                charFreq[i] --;
            }
        }

        return String.valueOf(res);
    }

}
