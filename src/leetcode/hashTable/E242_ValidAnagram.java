package leetcode.hashTable;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/19 15:08
 * @desc: https://leetcode.com/problems/valid-anagram/
 */
public class E242_ValidAnagram {

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
