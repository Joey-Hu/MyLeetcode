package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/28 14:07
 * @desc: https://leetcode.com/problems/increasing-decreasing-string/
 */
public class E1370_IncreasingDecreasingString {

    /**
     * 统计s中各个字符的个数，得到数组freq[]；
     * 然后从a-z遍历，如果freq中存在该字符，添加的res中，数量减一
     * 然后从z-a遍历一遍
     * @param s
     * @return
     */
    public String sortString(String s) {
        int[] freq = new int[26];
        StringBuilder res = new StringBuilder();
        boolean reverse = true;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a'] ++;
        }
        while (!allZero(freq)) {
            if (reverse) {
                for (int i = freq.length-1; i >= 0; i--) {
                    if (freq[i] > 0) {
                        res.append((char)('a' + i));
                        freq[i] --;
                    }
                }
                reverse = false;
            }else {
                for (int i = 0; i < freq.length; i++) {
                    if (freq[i] > 0) {
                        res.append((char)('a' + i));
                        freq[i] --;
                    }
                }
                reverse = true;
            }
        }
        return res.toString();
    }

    private boolean allZero(int[] chars) {
        for (int aChar : chars) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }
}
