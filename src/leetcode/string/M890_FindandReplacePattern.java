package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/28 15:08
 * @desc: https://leetcode.com/problems/find-and-replace-pattern/
 */
public class M890_FindandReplacePattern {
    /**
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (isMatch(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    /**
     * 字符串模式匹配
     * 两个数组用于记录每一个字符出现的位置，如果对应字符出现的位置不一样，就返回false
     * @param word
     * @param pattern
     * @return
     */
    private boolean isMatch(String word, String pattern) {
        int[] idxw = new int[26];
        int[] idxp = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if (idxw[word.charAt(i)-'a'] != idxp[pattern.charAt(i)-'a']) {
                return false;
            }
            idxw[word.charAt(i)-'a'] = idxp[pattern.charAt(i)-'a'] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        new M890_FindandReplacePattern().findAndReplacePattern(words, pattern);
    }
}
