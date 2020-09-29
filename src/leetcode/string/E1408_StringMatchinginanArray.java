package leetcode.string;

import LCCI.FirstCommonAncestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/29 20:34
 * @desc: https://leetcode.com/problems/string-matching-in-an-array/
 */
public class E1408_StringMatchinginanArray {

    /**
     * 逐个比较
     * 时间复杂度 O(n^3)
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isSubstring(words[i], words[j])) {
                    String temp = words[i].length() > words[j].length() ? words[j] : words[i];
                    if (!res.contains(temp)) {
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

    private boolean isSubstring(String str1, String str2) {
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for (int i = 0; i < str2.length()-str1.length()+1; i++) {
            int j = i + str1.length();
            if (str2.substring(i, j).equals(str1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(n^2)
     * @param words
     * @return
     */
    public List<String> stringMatching2(String[] words) {

        // implement the comparator
        Arrays.sort(words, new java.util.Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            while(j < words.length) {
                int index = words[j++].indexOf(words[i]);
                if (index != -1) {
                    // If not -1, means it is a substring. Add to list and break inner loop
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        new E1408_StringMatchinginanArray().isSubstring("mass", "as");
    }
}
