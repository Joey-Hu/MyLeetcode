package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/23 8:55
 * @desc: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class M524_LongestWordinDictionarythroughDeleting {

    /**
     * 遍历 d, 检查每一个字符串是不是 s 的子序列，然后判断长度是不是大于最大长度,
     * 如果等于最大长度，按字典顺序比较两字符串
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        if (d.size() == 0) {
            return "";
        }

        String longestWord = "";
        for (int i = 0; i < d.size(); i++) {
            if (isSubSequence(s, d.get(i))) {
                if (d.get(i).length() > longestWord.length()) {
                    longestWord = d.get(i);
                }else if (d.get(i).length() == longestWord.length() && d.get(i).compareTo(longestWord) < 0) {
                    longestWord = d.get(i);
                }
            }
        }
        return longestWord;
    }

    private boolean isSubSequence(String s, String str) {
        if (str.length() > s.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str.length();
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        String s = "abpcplea";
        new M524_LongestWordinDictionarythroughDeleting().findLongestWord(s, d);

    }
}
