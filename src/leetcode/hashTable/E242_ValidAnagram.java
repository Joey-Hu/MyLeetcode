package leetcode.hashTable;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/19 15:08
 * @desc: https://leetcode.com/problems/valid-anagram/
 */
public class E242_ValidAnagram {

    /**
     * 数组
     * O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i)-'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            charArray[t.charAt(i)-'a'] --;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 排序比较
     * O(NlogN)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return (new String(sArray)).equals(new String(tArray));
    }

    public static void main(String[] args) {
        new E242_ValidAnagram().isAnagram("anagram", "nagaram");
    }
}
